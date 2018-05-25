1. Create a maven project, add dependencies into the pom.xml file. 
2. Run **mvn clean install** to get the jar under target folder
3. Create/Re-use the Dockerfile  similar to the one under this repo else refer to this [link](https://www.youtube.com/watch?v=FlSup_eelYE)
4. Use the following commands to create and run the project as a docker image
    a) `docker build -t spring-docker .` ( run from the directory where the docker file is placed else provide the absolute path)
    b) The output should look like
        Sending build context to Docker daemon  15.94MB
        Step 1/4 : FROM openjdk:8
        8: Pulling from library/openjdk
        cc1a78bfd46b: Pull complete 
        6861473222a6: Pull complete 
        7e0b9c3b5ae0: Pull complete 
        3ec98735f56f: Pull complete 
        55160131808f: Pull complete 
        a8dbacf623ff: Pull complete 
        8145eb5a3756: Pull complete 
        589f3fe8a9cb: Pull complete 
        4f8dbecaf7f7: Pull complete 
        Digest: sha256:49d76c26366af08b15dda9e5c1288b2bdf02c7bc1699a623cfd0d17b1907c2e2
        Status: Downloaded newer image for openjdk:8
         ---> d480a7da7735
        Step 2/4 : ADD target/docker-spring-boot.jar docker-spring-boot.jar
         ---> f56a26ed7e04
        Step 3/4 : EXPOSE 8080
         ---> Running in 8f31093de2d3
        Removing intermediate container 8f31093de2d3
         ---> 0dfcf8b35c9a
        Step 4/4 : ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]
         ---> Running in 5251e0107a79
        Removing intermediate container 5251e0107a79
         ---> a3067a0d1ed4
        Successfully built a3067a0d1ed4
        Successfully tagged spring-docker:latest
    c)  Run the docker image
        `docker run test-spring`
    d) If required use the container id to enter into the docker shell
        `docker exec -it a3067a0d1ed4 /bin/bash`
5.  From the browser or postman execute commands to do CRUD operations
    a) GET localhost:8080/students/all
    b) GET localhost:8080/students/1
    c) POST localhost:8080/students/
            Body::
            {
                    "id": 23,
                    "name": "Student23",
                    "course": "JavaScript"
            }            
        