Steps to follow:

0- Create a folder named "ansible" in your home folder and download all the ansible files from https://github.com/obarrielv/devops

1- sudo yum install epel-release -y

2- sudo yum install ansible -y

3- sudo ansible-playbook ansible/docker.yml

4- sudo ansible-playbook ansible/jenkins.yml

5- sudo docker run --rm -u root -p 8080:8080 -v /var/run/docker.sock:/var/run/docker.sock knossiod/test:firsttry

5.1 - Browse localhost:8080, the installation password should be in the terminal running the container, complete the installation wizard 
and log into Jenkins.

5.2 - Inside Jenkins go to Manage Jenkins => Manage Plugins and install the "Pipeline Maven Integration" plugin. Then go to Manage Jenkins => Global Tool Configuration check for "Maven Installations" and add one with name "maven", for the version the last it's fine.

5.3 - Now create a Job: go to New Item => Multibranch Pipeline. Add a source (Github) with the given credentials, the repository is "test".
Once finished the job creation automatically the job will run creating two docker images (production and staging) with the microservice in. 

6- sudo ansible-playbook ansible/deploy.yml

7- sudo ansible-playbook ansible/nginx.yml

8- happy testing :)
