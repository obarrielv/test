Prerequisites:

- Docker

Steps to follow:

1 - Download Jenkins Image:  docker pull knossiod/test:firsttry

2 - Start Jenkins Docker Container: docker run -p 8080:8080 knossiod/test:firsttry

3 - Browse localhost:8080 user and pass "admin"

4 - Run Test Job (you can select master or release).

5 - Start Test Docker Container: docker run -p 8081:8080 test (The service should be running over pot 8081)
