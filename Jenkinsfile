pipeline {
    agent any

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-credentials',
                    url: 'https://github.com/RoshaniM5/PTax.git'
            }
        }

        stage('Run Automation Tests') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        success {
            emailext(
                to: 'akshayalshi10@gmail.com',
                subject: "SUCCESS: Jenkins Build #${BUILD_NUMBER}",
                body: """
Hello Team,

Automation test execution completed successfully.

Job Name      : ${JOB_NAME}
Build Number  : ${BUILD_NUMBER}
Build Status  : SUCCESS
Build URL     : ${BUILD_URL}

Regards,
Jenkins
"""
            )
        }

        failure {
            emailext(
                to: 'roshanimulunde0@gmail.com',
                subject: "FAILED: Jenkins Build #${BUILD_NUMBER}",
                body: """
Hello Team,

Automation test execution failed.

Job Name      : ${JOB_NAME}
Build Number  : ${BUILD_NUMBER}
Build Status  : FAILED
Build URL     : ${BUILD_URL}

Regards,
Jenkins
"""
            )
        }
    }
}

