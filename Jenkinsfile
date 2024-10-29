String gitCredentials="gitCredentials"

pipeline {
    agent any
    stages {
        stage("Code from Repo...") {
            steps {
                git url: "https://github.com/barkurguru/resoluteai.git", branch: "main", credentialsId: gitCredentials
            }
        }
        stage("Maven build...") {
            steps {
                sh "mvn clean package"
            }
        }
        stage("Docker Building image..") {
            steps {
                sh "whoami"
                sh "docker build -t app  ."
            }
        }
     
    }
}
