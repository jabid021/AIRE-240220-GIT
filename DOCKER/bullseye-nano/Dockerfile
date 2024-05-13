# Depuis quelle image Docker je pars
FROM debian:bullseye

# Exposer un port = dire que ce port est accessible
EXPOSE 8080

# Se positionner dans le répertoire /app
WORKDIR /app

# Les commandes à exécuter
RUN apt update

RUN apt install nano -y

# Copier le fichier "demo.txt" dans /app
# COPY demo.txt demo.txt
COPY rep toto

# CMD : on peut choisir, au moment du run du container, de modifier la commande
# CMD [ "mvnw", "spring-boot:run" ]

# ENTRYPOINT : on ne peut pas modifier
# ENTRYPOINT [ "mvnw", "spring-boot:run" ]
