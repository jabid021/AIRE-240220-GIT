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
