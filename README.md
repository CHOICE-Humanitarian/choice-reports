

# Setup choice-reports development environment on MacOSX or Linux (Fedora, RHEL, CentOS, Ubuntu)

## Install Ansible dependencies on Linux

```bash
pkcon install -y git
pkcon install -y python3
pkcon install -y python3-pip
pkcon install -y python3-virtualenv
```

## Install Ansible dependencies on MacOSX

```bash
brew install git python gnu-tar
pip3 install virtualenv
```

## Install the latest Python and setup a new Python virtualenv

This step might be virtualenv-3 for you. 

```bash
virtualenv ~/python

source ~/python/bin/activate
echo "source ~/python/bin/activate" | tee -a ~/.bashrc
source ~/.bashrc
```

## Install the latest Ansible

```bash
pip install setuptools_rust wheel
pip install --upgrade pip
pip install ansible
```

# Setup the project

## Setup the directory for the project and clone the git repository into it 

```bash
install -d ~/.local/src/choice-reports
git clone git@github.com:CHOICE-Humanitarian/choice-reports.git ~/.local/src/choice-reports
```

## Setup the Ansible Galaxy roles for installing the complete project locally. 

```bash
install -d ~/.ansible/roles
git clone git@github.com:computate-org/computate_postgres.git ~/.ansible/roles/computate.computate_postgres
git clone git@github.com:computate-org/computate_zookeeper.git ~/.ansible/roles/computate.computate_zookeeper
git clone git@github.com:computate-org/computate_solr.git ~/.ansible/roles/computate.computate_solr
git clone git@github.com:computate-org/computate_project.git ~/.ansible/roles/computate.computate_project
```

## Run the Ansible Galaxy roles to install the complete project locally. 

```bash
ansible-playbook ~/.ansible/roles/computate.computate_postgres/install.yml -K
ansible-playbook ~/.ansible/roles/computate.computate_zookeeper/install.yml -K
ansible-playbook ~/.ansible/roles/computate.computate_solr/install.yml -K
ansible-playbook ~/.ansible/roles/computate.computate_project/install.yml -e SITE_NAME=choice-reports -e ENABLE_CODE_GENERATION_SERVICE=true
```

## Running the project install to override secret variables

You can also inject your own secret variables with an Ansible Vault into the project install automation if you want to override any values. 

Here is an example of creating a vault directory and creating a new vault, it will ask for a password. 
Be sure to not commit your vault to source control, it should be ignored by default in the .gitignore file that is created in the project. 

```bash
install -d ~/.local/src/choice-reports-ansible/vault
ansible-vault create ~/.local/src/choice-reports-ansible/vault/$USER-local
```

You can edit the vault, it will ask for the password. 

```bash
ansible-vault edit ~/.local/src/choice-reports-ansible/vault/$USER-local
```

You can then run the project install automation again with the secrets in the vault, it will ask for the password. 

```bash
ansible-playbook ~/.ansible/roles/computate.computate_project/install.yml -e SITE_NAME=choice-reports -e ENABLE_CODE_GENERATION_SERVICE=true -e @~/.local/src/choice-reports-ansible/vault/$USER-local --vault-id @prompt
```

# Configure Red Hat CodeReady Studio

You can download Red Hat Code Ready Studio here: 

https://developers.redhat.com/products/codeready-studio/download

You will want to create a Red Hat account if you do not already have one. 

After you download CodeReady Studio, create a directory for it and install it with this command: 

```bash
install -d ~/.local/opt/codereadystudio
java -jar ~/Downloads/codereadystudio-*-installer-standalone.jar
```

You can use the default installation settings. I suggest to install CodeReady Studio in your in $HOME/.local/opt/codereadystudio

When you run CodeReady Studio, I suggest you create your workspace here: ~/.local/src

## Install these update sites: 

In CodeReady Studio, go to Help -> Install New Software...

Add these update sites and install these useful plugins: 

### Vrapper Vim Plugin
- http://vrapper.sourceforge.net/update-site/stable
    - Choose the "Vrapper" plugin if you want to be able to edit code with Vim commands
    - Vrapper keys to unbind in Window -> Preferences -> General -> Keys: 
        - ctrl+d, ctrl+u, ctrl+r, shift+ctrl+v, alt+v
    - Vrapper keys to set: 
        - and search for "Vrapper" and set the keys to alt+v

### DevStyle for dark theme

- http://www.genuitec.com/updates/devstyle/ci/
    - Choose "DevStyle Features" for themes

### YAML Editor

- http://www.genuitec.com/updates/devstyle/ci/
    - Choose "DevStyle Features" for themes

## Import the choice-reports project into CodeReady Studio

* In CodeReady Studio, go to File -> Import...
* Select Maven -> Existing Maven Projects
* Click [ Next > ]
* Browse to the directory: ~/.local/src/choice-reports
* Click [ Finish ]

## Setup a CodeReady Studio Debug/Run configuration to generate the OpenAPI 3 spec and the SQL create and drop scripts in choice-reports

* In CodeReady Studio, go to File -> Debug Configurations...
* Right click on Java Application -> New Configuration
* Name: choice-reports-OpenAPIGenerator
* Project: choice-reports
* Main class: org.choicehumanitarian.reports.enus.vertx.MainVerticle

### In the Environment tab

Setup the following variables to setup the Vert.x verticle. 

* CONFIG_PATH: ~/.local/src/choice-reports/config/choice-reports.yml
* RUN_OPENAPI3_GENERATOR: true
* RUN_SQL_GENERATOR: true

Click [ Apply ] and [ Debug ] to debug the generation of the OpenAPI Spec src/main/resources/webroot and the SQL create and drop scripts in src/main/resources/sql. 

## Setup a CodeReady Studio Debug/Run configuration to run and debug choice-reports

* In CodeReady Studio, go to File -> Debug Configurations...
* Right click on Java Application -> New Configuration
* Name: choice-reports
* Project: choice-reports
* Main class: org.choicehumanitarian.reports.enus.vertx.MainVerticle

### In the "Arguments" tab

Setup the following VM arguments to disable caching for easier web development: 

```
-DfileResolverCachingEnabled=false -Dvertx.disableFileCaching=true
```

### In the Environment tab

Setup the following variables to setup the Vert.x verticle. 

* CONFIG_PATH: ~/.local/src/choice-reports/config/choice-reports.yml
* VERTXWEB_ENVIRONMENT: dev

Click [ Apply ] and [ Debug ] to debug the application. 

# Deploy choice-reports to OpenShift with Ansible

To deploy choice-reports to OpenShift with Ansible, you will want to follow the instructions to install Ansible on your system first above "Install Ansible dependencies on Linux". 

## Setup ~/.ansible/roles directory

A default place to install Ansible roles from Ansible Galaxy is in ~/.ansible/roles. Make sure this directory exists: 

```bash
install -d ~/.ansible/roles
```

## Clone the Ansible roles for deploying the applications to OpenShift

```bash
git clone git@github.com:computate-org/computate_postgres_openshift.git ~/.ansible/roles/computate.computate_postgres_openshift
git clone git@github.com:computate-org/computate_zookeeper_openshift.git ~/.ansible/roles/computate.computate_zookeeper_openshift
git clone git@github.com:computate-org/computate_solr_openshift.git ~/.ansible/roles/computate.computate_solr_openshift
git clone git@github.com:computate-org/computate_project_openshift.git ~/.ansible/roles/computate.computate_project_openshift
```

## Create an ansible vault for your OpenShift.

You can create and edit an encrypted ansible vault with a password for the host secrets for your shared OpenShift inventory to deploy choice-reports.
It will have you create a password when you save the file for the first time, like using vim to exit. 

```bash
install -d ~/.local/src/choice-reports-ansible
install -d ~/.local/src/choice-reports-ansible/vault/$USER-staging/vault
ansible-vault create ~/.local/src/choice-reports-ansible/vault/$USER-staging/vault
ansible-vault edit ~/.local/src/choice-reports-ansible/vault/$USER-staging/vault
```

Here is an example of a vault that I have used to deploy the choice-reports application. 
You will want to update these values to reflect your OpenShift environment, like the REDHAT_OPENSHIFT_TOKEN which you will need to obtain after logging into OpenShift. 
Or the REDHAT_OPENSHIFT_STORAGE_CLASS_NAME which might be different than gp2 for you. 
If so, try creating a persistent volume in the UI to figure out a good storage class for your environment: 

```yaml
SITE_NAME: choice-reports

REDHAT_OPENSHIFT_HOST: https://api.rh-us-east-1.openshift.com
REDHAT_OPENSHIFT_TOKEN: OcrtrXzKNKVj0riR2FvfqORgGfnURx98G8zRPd2MUvs
REDHAT_OPENSHIFT_NAMESPACE: rh-impact
REDHAT_OPENSHIFT_STORAGE_CLASS_NAME: gp2

POSTGRES_DB_NAME: sampledb
POSTGRES_DB_USER: computate
POSTGRES_DB_PASSWORD: qVTaaa23aIkLmw
POSTGRES_VOLUME_SIZE: 1Gi
POSTGRES_STORAGE_CLASS_NAME: "{{ REDHAT_OPENSHIFT_STORAGE_CLASS_NAME }}"

ZOOKEEPER_VOLUME_SIZE: 1Gi
ZOOKEEPER_STORAGE_CLASS_NAME: "{{ REDHAT_OPENSHIFT_STORAGE_CLASS_NAME }}"

SOLR_VOLUME_SIZE: 2Gi
SOLR_STORAGE_CLASS_NAME: "{{ REDHAT_OPENSHIFT_STORAGE_CLASS_NAME }}"

AUTH_REALM: TEAM19
AUTH_RESOURCE: team19
AUTH_SECRET: 0518f65a-f86d-42e8-ad65-00f46920443d
AUTH_HOST_NAME: sso.computate.org
AUTH_PORT: 443
AUTH_SSL: true
AUTH_TOKEN_URI: "/auth/realms/RH-IMPACT/protocol/openid-connect/token"
```

## Run the Ansible automation to deploy the applications to OpenShift

```bash

ansible-playbook --vault-id @prompt -e @~/.local/src/choice-reports-ansible/vault/$USER-staging/vault ~/.ansible/roles/computate.computate_postgres_openshift/install.yml -e SITE_NAME=choice-reports

ansible-playbook --vault-id @prompt -e @~/.local/src/choice-reports-ansible/vault/$USER-staging/vault ~/.ansible/roles/computate.computate_zookeeper_openshift/install.yml -e SITE_NAME=choice-reports

ansible-playbook --vault-id @prompt -e @~/.local/src/choice-reports-ansible/vault/$USER-staging/vault ~/.ansible/roles/computate.computate_solr_openshift/install.yml -e SITE_NAME=choice-reports

ansible-playbook --vault-id @prompt -e @~/.local/src/choice-reports-ansible/vault/$USER-staging/vault ~/.ansible/roles/computate.computate_project_openshift/install.yml -e SITE_NAME=choice-reports
```

## How to run the application as a Podman container

### Install the prerequiste packages for buildah and podman

```bash
pkcon install -y buildah
pkcon install -y podman
```

### Build the container with podman

```bash
cd ~/.local/src/choice-reports
podman build -t computate/choice-reports:latest .
```

### Push the container up to quay.io
```bash
podman login quay.io
podman push computate/choice-reports:latest quay.io/computate/choice-reports:latest
```


1. **Test area**
    * Description
    * Acceptance tests:
        5. Validate the project:
            1. For a given project named `012345myproject` for example, check that the given project is listed in the `oc` CLI:
                1. 
                    ```bash
                    $ oc get project/012345myproject
                    NAME             DISPLAY NAME  STATUS
                    012345myproject                Active
                    ```