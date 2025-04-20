FROM maven:3.9.6-eclipse-temurin-17

RUN apt-get update &&     apt-get install -y curl git gnupg2 &&     curl -sL https://deb.nodesource.com/setup_20.x | bash - &&     apt-get install -y nodejs

RUN npm install -g @angular/cli
