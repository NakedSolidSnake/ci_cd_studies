# Studies about CI/CD
This project has the intention to understand how works all the build and deploy process.

## Backend

### Run application through CLI
```bash
$ java -jar target/deploy-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```

### Run application through Docker
```base
$ cd ci_cd_studies/backend/deploy
$ mvn clean install
$ cd ..
$ docker build -t persons .
$ docker container run --name persons -d --net=host -p 9000:9000  persons
```
