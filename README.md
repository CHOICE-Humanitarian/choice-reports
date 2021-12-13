
# Setup choice-reports development environment on MacOSX or Linux (Fedora, RHEL, CentOS)

## Install Ansible dependencies on Linux

```bash
pkcon install -y git
pkcon install -y python3-pip
pkcon install -y python3-virtualenv
```

## Install Ansible dependencies on MacOSX

```bash
brew install git python gnu-tar
pip3 install virtualenv
```

## Install the latest Python and setup a new Python virtualenv

```bash
# This step might be virtualenv-3 for you. 
virtualenv ~/python

source ~/python/bin/activate
echo "source ~/python/bin/activate" | tee -a ~/.bash_profile
```

## Install the latest Ansible

```bash
pip install setuptools_rust wheel
pip install --upgrade pip
```

## Install dependencies on Linux

```bash
pkcon install -y maven
pkcon install -y gcc
pkcon install -y make
pkcon install -y git
pkcon install -y bison
pkcon install -y flex
pkcon install -y readline-devel
pkcon install -y zlib-devel
pkcon install -y systemd-devel
pkcon install -y libxml2-devel
pkcon install -y libxslt-devel
pkcon install -y openssl-devel
pkcon install -y perl-core
pkcon install -y libselinux-devel
pkcon install -y container-selinux
pkcon install -y java-1.8.0-openjdk
pkcon install -y java-11-openjdk
```

## Install dependencies on MacOSX

```bash
brew install maven
```

# Setup Ansible

## Install python3 application dependencies

```bash
pip3 install psycopg2-binary
```

## Setup the directory for the project and clone the git repository into it 

```bash
install -d ~/.local/src/choice-reports
git clone git@github.com:team19hackathon2021/choice-reports.git ~/.local/src/choice-reports
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

cd ~/.ansible/roles/computate.computate_postgres
ansible-playbook install.yml

cd ~/.ansible/roles/computate.computate_zookeeper
ansible-playbook install.yml

cd ~/.ansible/roles/computate.computate_solr
ansible-playbook install.yml

cd ~/.ansible/roles/computate.computate_project
ansible-playbook install.yml -e SITE_NAME=choice-reports -e ENABLE_CODE_GENERATION_SERVICE=true
```

# Configure Eclipse

## Install the Maven plugin for Eclipse

* In Eclipse, go to Help -> Eclipse Marketplace...
* Install "Maven Integration for Eclipse"

## Import the choice-reports project into Eclipse

* In Eclipse, go to File -> Import...
* Select Maven -> Existing Maven Projects
* Click [ Next > ]
* Browse to the directory: ~/.local/src/choice-reports
* Click [ Finish ]

## Setup an Eclipse Debug/Run configuration to run and debug choice-reports

* In Eclipse, go to File -> Debug Configurations...
* Right click on Java Application -> New Configuration
* Name: choice-reports QuarkusApp
* Project: choice-reports
* Main class: org.choicehumanitarian.reports.enus.quarkus.QuarkusApp

### In the "Arguments" tab

Setup the following VM arguments to disable caching for easier web development: 

```
-DfileResolverCachingEnabled=false -Dvertx.disableFileCaching=true
```

### In the Environment tab

Setup the following variables to setup the Vert.x verticle. 

* CLUSTER_PORT: 10991
* CONFIG_PATH: ~/.local/src/choice-reports/config/choice-reports.yml
* SITE_INSTANCES: 5
* VERTXWEB_ENVIRONMENT: dev
* WORKER_POOL_SIZE: 2
* ZOOKEEPER_HOST_NAME: localhost
* ZOOKEEPER_PORT: 2181

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
install -d ~/.local/src/choice-reports-ansible/vaults/$USER-staging/vault
ansible-vault create ~/.local/src/choice-reports-ansible/vaults/$USER-staging/vault
ansible-vault edit ~/.local/src/choice-reports-ansible/vaults/$USER-staging/vault
```

The contents of the vault will contain the secrets needed to override any default values you want to change in the app defaults defined here.

https://github.com/team19hackathon2021/choice-reports/blob/main/openshift/defaults.yml

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
POSTGRES_STORAGE_CLASS_NAME: gp2

ZOOKEEPER_VOLUME_SIZE: 1Gi
ZOOKEEPER_STORAGE_CLASS_NAME: gp2

SOLR_VOLUME_SIZE: 2Gi
SOLR_STORAGE_CLASS_NAME: gp2

AUTH_REALM: TEAM19
AUTH_RESOURCE: team19
AUTH_SECRET: 0518f65a-f86d-42e8-ad65-00f46920443d
AUTH_HOST_NAME: sso.computate.org
AUTH_PORT: 443
AUTH_SSL: true
AUTH_TOKEN_URI: "/auth/realms/{{ AUTH_REALM }}/protocol/openid-connect/token"
```

## Run the Ansible automation to deploy the applications to OpenShift

```bash

ansible-playbook --vault-id @prompt -e @~/.local/src/choice-reports-ansible/vaults/$USER-staging/vault ~/.ansible/roles/computate.computate_postgres_openshift/install.yml

ansible-playbook --vault-id @prompt -e @~/.local/src/choice-reports-ansible/vaults/$USER-staging/vault ~/.ansible/roles/computate.computate_zookeeper_openshift/install.yml

ansible-playbook --vault-id @prompt -e @~/.local/src/choice-reports-ansible/vaults/$USER-staging/vault ~/.ansible/roles/computate.computate_solr_openshift/install.yml

ansible-playbook --vault-id @prompt -e @~/.local/src/choice-reports-ansible/vaults/$USER-staging/vault ~/.ansible/roles/computate.computate_project_openshift/install.yml
```

## See the choice-reports application staged here in OpenShift

https://choice-reports.computate.org/
