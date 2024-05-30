# Clickhouse

## Le container Docker avec son image

```bash
docker run -d -p 8123:8123 --name ajc-clickhouse clickhouse/clickhouse-server
```

## Accéder au container avec bash

```bash
docker exec -it ajc-clickhouse bash
```

## Lancer le client Clickhouse

```bash
clickhouse-client
```

## Exécuter une requête

```sql
SHOW DATABASES;
```

### Créer une base

```sql
CREATE DATABASE solarwind;
USE solarwind;
```

### Créer une table

```sql
CREATE TABLE wind (
    date VARCHAR(20),
    speed Float32,
    density Float32,
    bt Float32,
    bz Float32
)
ENGINE = MergeTree()
ORDER BY date;
```

## En JAVA

Ajouter la dépendance MAVEN : connecteur Clickhouse

```xml
<dependency>
    <groupId>com.clickhouse</groupId>
    <artifactId>clickhouse-jdbc</artifactId>
    <version>0.6.0</version>
    <classifier>all</classifier>
</dependency>
```

# Hadoop

## Fabriquer l'image Docker

Exécuter dans le répertoire dans lequel se trouve le Dockerfile et les fichiers XML à copier

```bash
docker build -t hadoop .
```

## Exécuter le container

### Namenode

```bash
docker run -it --network host hadoop
bin/hdfs namenode -format
bin/hdfs namenode
```

### Datanode

```bash
docker run -it --network host hadoop
bin/hdfs datanode
```

### Sur notre machine locale

```bash
docker run --rm -it -v "D:/VOTRE_REPERTOIRE_DONNEES":/data hadoop
```

## Quelques commandes pour manipuler le HDFS distant

```bash
hadoop fs -ls / # Permet de lister les fichiers et répertoires à la racine de HDFS
hadoop fs -mkdir /sonprenom # Permet de créer un répertoire sur le HDFS
hadoop fs -put /data/sonprenom.txt /sonprenom # Permet d'envoyer un fichier local vers le HDFS
hadoop fs -cat /sonprenom/sonprenom.txt # Permet de lire le contenu d'un fichier sur le HDFS
hadoop fs -rm /sonprenom/sonprenom.txt # Permet de supprimer un fichier sur le HDFS
hadoop fs -rm -R /sonprenom # Permet de supprimer un répertoire sur le HDFS de manière récursive
```

## En JAVA

Ajouter la dépendance MAVEN pour piloter le HDFS

```xml
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-client</artifactId>
    <version>3.4.0</version>
</dependency>
```


# Flume

## Fabriquer l'image Docker

Exécuter dans le répertoire dans lequel se trouve le Dockerfile et le fichier de config à copier

```bash
docker build -t flume .
```

## Exécuter le container

```bash
docker run --rm -it -v "D:/VOTRE_REPERTOIRE_FLUME_AVEC_FICHIER_CONFIG":/flume/conflocale -v "D:/VOTRE_REPERTOIRE_FICHIERS_A_DONNER_A_FLUME":/flume/spool flume
```

## Lancer l'agent Flume "agent1" avec le fichier de configuration "spooldir.conf" et 512Mo de mémoire vive pour Flume

```bash
flume-ng agent -n agent1 -f conflocale/spooldir.conf -Xmx512m
```


# MapReduce en JAVA

Adapter la version de JAVA dans laquelle on compile de code à la version de JAVA qui se trouve sur les Datanode (sur le Namenode)

Dans le pom.xml :

```xml
<properties>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
</properties>
```

Intégrer 2 dépendances Hadoop

```xml
<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-common</artifactId>
    <version>3.4.0</version>
</dependency>

<dependency>
    <groupId>org.apache.hadoop</groupId>
    <artifactId>hadoop-mapreduce-client-core</artifactId>
    <version>3.4.0</version>
</dependency>
```

## Compiler l'application JAVA en jar

```bash
mvn clean package
```

## Faire exécuter le jar 

Démarrer un container Hadoop, avec un mapping de volume sur le répertoire target du projet JAVA

Aller dans le répertoire mappé sur le container

```bash
hadoop jar map-reduce.jar fr.formation.Application /phrase.txt /output_jeremy
```
