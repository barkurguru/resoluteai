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
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    cmd 'docker build -t barkurguru/employeeapp .'
                }
            }
        }


        stage('Deploy to EKS') {
            steps {
                script {
                    withKubeConfig([credentialsId: 'kubeconfig-credentials', serverUrl: 'https://your-eks-cluster-url']) {
                        cmd 'kubectl apply -f kubernetes/k8s.yaml'
                    }
                }
            }
        }
    }
}
