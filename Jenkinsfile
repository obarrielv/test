node {

        stage('Build') {

            git url: 'https://github.com/cyrille-leclerc/multi-module-maven-project'
            withMaven(
                maven: 'maven'
            ) {
                sh "mvn clean install"
            }
          }

        stage('Test') {


                        withMaven(
                            maven: 'maven'
                        ) {
                            sh "mvn clean test"
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

        }

}