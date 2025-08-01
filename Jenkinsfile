pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                script {
                    checkout scm
                }
            }
        }

        stage('Build and Test') {
            steps {
                script {
                    bat 'mvn -X clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t barkurguru/employeeapp .'
                }
            }
        }


        stage('Deploy ') {
            steps {
                script {
                        bat 'kubectl apply -f k8s-deploy.yaml'
                    }
                }
            }

            stage('Service ') {
            steps {
                script {
                        bat 'kubectl apply -f k8s-service.yaml'
                    }
                }
            }
        
        }
    }
}
