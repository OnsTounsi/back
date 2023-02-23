pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'main']],
                    userRemoteConfigs: [[url: 'https://github.com/OnsTounsi/back.git']]
                ])
            }
        }

       stage('MVN CLEAN') {
             steps {
                      withMaven() {
                     bat 'mvn clean compile'

                  }
             }
       }

        stage('MVN COMPILE') {
              steps {
                        bat 'mvn compile'

              }
        }

        stage('MVN PACKAGE') {
               steps {
                        bat 'mvn package'

               }
        }

        stage('MVN TEST') {
            steps {
                      bat 'mvn test'

            }
        }
        stage('MVN SONARQUBE') {
                    steps {
                        bat 'mvn sonar:sonar  -Dsonar.projectKey=back  -Dsonar.host.url=http://localhost:9000    -Dsonar.login=sqp_c1e41eababf2852dd686f77ab44a64b0e6cbba04'
                    }
                }

    }
}


