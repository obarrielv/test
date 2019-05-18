node {

        stage('Build') {
        steps {
            git url: 'https://github.com/cyrille-leclerc/multi-module-maven-project'
            withMaven(
                maven: 'maven'
            ) {
                sh "mvn clean install"
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
            agent {
                  docker {
                        image 'test'
                    }
            }
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
            agent {
                              docker {
                                    image 'test'
                                }
                        }
            steps{
                echo 'Deploying....'
            }
        }

}