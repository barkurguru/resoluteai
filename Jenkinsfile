pipeline {
    agent {
        node {
            label 'dev'
        }
    }

    stages {
        stage("Code from Repo...") {
            steps {
                git url: "https://github.com/barkurguru/resoluteai.git", branch: "main"
            }
        }
        stage("Docker Build") {
            steps {
                sh "whoami"
                sh "docker build -t app  ."
            }
        }
     
    }
}


