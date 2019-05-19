pipeline {
    agent any
    stages {
        stage('Test') {
            steps {

                        withMaven(
                            maven: 'maven'
                        ) {
                            sh "mvn clean test spring-boot:run"
                        }

            }
        }
        stage('Deploy to staging') {
                 when {
                                branch 'release'
                                expression {
                                   currentBuild.result == null || currentBuild.result == 'SUCCESS'
                                }
                            }
                steps {

                    withMaven(
                        maven: 'maven'
                    ) {
                        sh "mvn clean package docker:build -DpushImage"
                        sh "docker build -t test ."
                    }
                  }
                }
          stage('Deploy to production') {
                   when {
                                  branch 'master'
                                  expression {
                                     currentBuild.result == null || currentBuild.result == 'SUCCESS'
                                  }
                              }
                  steps {

                      withMaven(
                          maven: 'maven'
                      ) {
                          sh "mvn clean package docker:build -DpushImage"
                          sh "docker build -t test ."
                      }
                    }
                  }

    }
}