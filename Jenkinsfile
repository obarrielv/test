pipeline {
    agent any
    tools {
        maven 'Maven 3.6.1'
    }
    stages {
        stage('Build') {
            git url: 'https://github.com/cyrille-leclerc/multi-module-maven-project'
            withMaven(
                maven: 'maven'
            ) {
                sh "mvn clean install"
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean test spring-boot:run'
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
                sh 'docker build -f DockerFile -t test .'
            }
        }
        stage('Deploy for production') {
            when {
                branch 'master'
                expression {
                    currentBuild.result == null || currentBuild.result == 'SUCCESS'
                }
            }
            steps{
                sh 'docker build -f DockerFile -t test .'
            }
        }
    }
}