FROM openjdk:11

WORKDIR /backend

COPY /deploy/target/*.jar persons.jar 

SHELL [ "/bin/sh", "-c"]

EXPOSE 9000

CMD java -jar persons.jar --spring.profiles.active=dev