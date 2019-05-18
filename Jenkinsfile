pipeline {
    agent any
    stages {
        stage('Build') {
        steps {

            withMaven(
                maven: 'maven'
            ) {
                sh "mvn package && java -jar /target/test-1.jar"
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