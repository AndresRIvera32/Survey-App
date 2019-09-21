FROM openjdk:8-jdk-alpine
LABEL maintainer="andres.rivera32@outlook.com"
WORKDIR /workspace
ADD target/api*.jar app.jar

#ENV userPoolId="us-east-1_hlkFh3upj"
#ENV clientId="4g7djgfm7db60an31fsuo15ig1"

ENTRYPOINT exec java -Djava.security.egd=file:/dev/./urandom -jar /workspace/app.jar
EXPOSE 8080