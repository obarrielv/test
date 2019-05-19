Prerequisites:

- Docker

Steps to follow:

1 - Download Jenkins Image:  docker pull knossiod/test:firsttry

2 - Start Jenkins Docker Container: docker run --rm -u root -p 8080:8080 -v /var/run/docker.sock:/var/run/docker.sock knossiod/test:firsttry

3 - Browse localhost:8080 user and pass "admin"

4 - Run Test Job (you can select master or release).

5 - Start Test Docker Container: docker run -p 8081:8080 production or
                                 docker run -p 8081:8080 staging 

6 - The service should be running over pot 8081 ready for testing
