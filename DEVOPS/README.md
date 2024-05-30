# SonarQube en container Docker

```bash
docker run -d --name ajc-sonar -p 9000:9000 sonarqube
```

# Maven

## Builder l'artifact

```bash
mvn clean package
```

## Builder l'artifact avec un rapport de couverture de code par JaCoCo

```bash
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent package org.jacoco:jacoco-maven-plugin:report
```

## Scanner le projet avec SonarQube

```bash
mvn clean verify sonar:sonar -Dsonar.projectKey=projet-1 -Dsonar.host.url="http://localhost:9000" -Dsonar.token=<token>
```

## Builder l'artifact avec un rapport de couverture de code par JaCoCo & scanner le projet avec SonarQube

```bash
mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent package verify org.jacoco:jacoco-maven-plugin:report sonar:sonar -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml -Dsonar.projectKey=projet-1 -Dsonar.host.url="http://localhost:9000" -Dsonar.token=<token>
```



# Machine Virtuelle sur Azure

Se rendre sur https://portal.azure.com/
Créer un compte, qui permet d'avoir 30 jours d'essais et $200 de crédit à utiliser

## Créer la machine virtuelle

Créer une nouvelle ressource de type "Virtual Machine"

Sélectionner l'image Ubuntu 20.04 LTS avec un type d'authentification par "Mot de passe", mettre "ajcuser" comme nom d'utilisateur et choisir un mot de passe

Laisser le port 22 (SSH) ouvert

## Ouvrir tous les ports

Une fois la machine créée, se rendre dans les "Paramètres réseau", créer une nouvelle "Règle de port d'entrée"

Saisir la plage de ports 0-65000 en laissant "Any" en protocole et "Autoriser" en action

## S'y connecter en SSH

Récupérer l'adresse IP de la machine virtuelle

Dans un terminal (ou avec l'application "Termius") se connecter en SSH

```bash
ssh ajcuser@adresse.ip # Puis taper "yes"
```


### Installer Docker sur la machine

Suivre les étapes d'installation du Docker Engine pour Ubuntu : https://docs.docker.com/engine/install/ubuntu/

```bash
# Add Docker's official GPG key:
sudo apt-get update
sudo apt-get install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc

# Add the repository to Apt sources:
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "$VERSION_CODENAME") stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update
```

#### Installer Docker

```bash
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

#### Vérifier l'installation

```bash
sudo docker ps
```

#### Donner les droits d'utilisation à l'utilisateur principal

```bash
sudo usermod -a -G docker ajcuser
```

#### Vérifier la manipulation

Se déconnecter et se reconnecter

```bash
docker ps
```


### Créer une clé SSH

```bash
ssh-keygen -t rsa -b 4096
cat nom_cle_utilisee.pub >> ~/.ssh/authorized_keys
cat nom_cle_utilisee # Copier ces informations dans le presse-papier, elles seront à utiliser sur Github Actions
```

