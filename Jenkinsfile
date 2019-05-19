pipeline {
    agent any
    stages {
        stage('Test') {
            steps {

                        withMaven(
                            maven: 'maven'
                        ) {
                            sh "mvn clean test"
                        }

            }
        }
        stage('Deploy to staging') {
                 when {branch 'release'}
                steps {

                    withMaven(
                        maven: 'maven'
                    ) {
                        sh "mvn clean package docker:build -DpushImage"
                        sh "docker build -t staging ."
                    }
                  }
                }
          stage('Deploy to production') {
                   when {branch 'master'}
                  steps {

                      withMaven(
                          maven: 'maven'
                      ) {
                          sh "mvn clean package docker:build -DpushImage"
                          sh "docker build -t production ."
                      }
                    }
                  }

    }
}