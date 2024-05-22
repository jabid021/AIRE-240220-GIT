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