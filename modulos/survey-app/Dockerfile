FROM openjdk:8-jdk-alpine
LABEL maintainer="andres.rivera32@outlook.com"
WORKDIR /workspace

#ENV userPoolId="us-east-1_hlkFh3upj"
#ENV host="bdsurvey.ckhhib4u0lah.us-east-1.rds.amazonaws.com"
#ENV port="3306"
#ENV database="surveyDatabase"

ENV DOCKERIZE_VERSION v0.6.1
#Podemos descargar dockerize o copiarlo desde un directorio
RUN wget https://github.com/jwilder/dockerize/releases/download/$DOCKERIZE_VERSION/dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && tar -C /usr/local/bin -xzvf dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz \
    && rm dockerize-alpine-linux-amd64-$DOCKERIZE_VERSION.tar.gz

ADD target/survey-app*.jar app.jar

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /workspace/app.jar
EXPOSE 8080