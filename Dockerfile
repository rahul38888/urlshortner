FROM maven AS build
WORKDIR /urlshortner
COPY . .
RUN mvn clean package

FROM tomcat AS deploy
COPY ./target/urlshortner-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/urlshortner.war
