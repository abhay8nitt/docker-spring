1. Create a maven project, add dependencies into the pom.xml file. 
2. Run **mvn clean install** to get the jar under target folder
3. Create/Re-use the Dockerfile  similar to the one under this repo else refer to this [link](https://www.youtube.com/watch?v=FlSup_eelYE)
4. Use the following commands to create and run the project as a docker image
    - `docker build -t spring-docker .` ( run from the directory where the docker file is placed else provide the absolute path. 
      Use -f switch to add the filepath)
    -  Run the docker image
        `docker run -p 8080:8080 spring-docker`
    - If required use the container id to enter into the docker shell
        `docker exec -it a3067a0d1ed4 /bin/bash`
5.  From the browser or postman execute commands to do CRUD operations
    - GET localhost:8080/students/all
    - GET localhost:8080/students/1
    - POST localhost:8080/students/
            `Body::
            {
                    "id": 23,
                    "name": "Student23",
                    "course": "JavaScript"
            } `           
        
