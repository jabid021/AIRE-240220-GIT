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
```

### Créer une table

```sql
CREATE TABLE wind (
    date VARCHAR(20),
    speed FLOAT,
    density FLOAT,
    bt FLOAT,
    bz FLOAT
)
ENGINE = MergeTree()
ORDER BY date;
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
docker run --rm -it -v "D:/Formations/a.formation/SUPPORTS/BIG DATA":/data hadoop
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


# Flume

## Fabriquer l'image Docker

Exécuter dans le répertoire dans lequel se trouve le Dockerfile et le fichier de config à copier

```bash
docker build -t flume .
```

## Exécuter le container

```bash
docker run --rm -it -v "D:/Formations/a.formation/SUPPORTS/BIG DATA/flume":/flume/conflocale -v "D:/pourflume":/flume/spool flume
```

## Quelques commandes pour manipuler Flume

```bash
flume-ng agent -n agent1 -f conflocale/spooldir.conf -Xmx512m
```
