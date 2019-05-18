pipeline {
    agent any
    stages {
        stage('Build') {
        steps {
            git url: 'https://github.com/obarrielv/test.git'
            withMaven(
                maven: 'maven'
            ) {
                sh "mvn clean install"
            }
          }
        }
        stage('Test') {
            steps {
                 git url: 'https://github.com/obarrielv/test.git'
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
            agent { dockerfile true }
            steps {
              echo 'Deploying....'
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