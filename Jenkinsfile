pipeline {
    agent any
    stages {
        stage('Build') {
        steps {

            withMaven(
                maven: 'maven'
            ) {
                sh "mvn package"
            }
          }
        }
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
                              sh "mvn package"
                          }
            }
             agent { dockerfile true }
        }
        stage('Deploy for production') {
            when {
                branch 'master'
                expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            agent { dockerfile true }
            steps{
                echo 'Deploying....'
            }
        }
    }
}