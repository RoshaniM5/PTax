pipeline {
    agent any

    tools {
    jdk 'JDK-17'
    maven 'Maven3'
}

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }
}
// trigger build
