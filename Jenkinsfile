pipeline {
    agent any
    stages {
        stage('Build') {
        steps {

            withMaven(
                maven: 'maven'
            ) {
                sh "mvn clean package docker:build -DpushImage"
                sh "docker build -t test ."
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
             sh "docker build -t snscaimito/ledger-service:${env.BUILD_ID} ."
            }
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