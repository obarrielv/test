Prerequisites:
- Docker

Steps to follow:
1 - Download Jenkins Image:  docker pull knossiod/test:firsttry
2 - Start Jenkins Docker Container: docker run  --rm  -u root   -p 8080:8080   -v jenkins-data:/var/jenkins_home    -v /var/run/docker.sock:/var/run/docker.sock   -v "$HOME":/home  knossiod/test:firsttry
3 - Browse localhost:8080 user and pass "admin"
4 - Run Test Job (you can select master or release).
