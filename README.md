Prerequisites:

- Docker

Steps to follow:

1 - Download Jenkins Image:  docker pull knossiod/test:firsttry

2 - Start Jenkins Docker Container: docker run --rm -u root -p 8080:8080 -v /var/run/docker.sock:/var/run/docker.sock knossiod/test:firsttry

3 - Browse localhost:8080, the installation password should be in the terminal running the container, complete the installation wizard 
and log into Jenkins.

4 - Inside Jenkins go to Manage Jenkins => Manage Plugins and install the "Pipeline Maven Integration" plugin. Then go to Manage Jenkins => Global Tool Configuration check for "Maven Installations" and add one with name "maven", for the version the last it's fine.

5 - Now create a Job: go to New Item => Multibranch Pipeline. Add a source (Github) with the given credentials, the repository is "test".
Once finished the job creation automatically the job will run creating two docker images (production and staging) with the microservice in. 

6 - Start the Docker Container:  docker run -p 8081:8080 production or
                                 docker run -p 8081:8080 staging 

7 - The service should be running over pot 8081 ready for testing
