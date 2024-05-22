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
docker run --rm -it hadoop
```
