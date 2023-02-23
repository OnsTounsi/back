pipeline {
    agent any
    stages {
        stage('Checkout GIT') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'main']],
                    userRemoteConfigs: [[url: 'https://github.com/OnsTounsi/exercice.git']]
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

        stage('MVN COMPILE') {
                            steps {
                                bat 'mvn compile'
                            }
                        }

        stage('MVN TEST') {
            steps {
                bat 'mvn test'
            }
        }

}
}


