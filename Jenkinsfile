pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'YOUR_GITHUB_REPOSITORY_URL'
            }
        }

        stage('Run Selenium Pipeline') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            echo "Automation execution completed"
        }
    }
}

    post {
        always {
            echo "BUILD RESULT = ${currentBuild.currentResult}"
            echo "BUILD NUMBER = ${BUILD_NUMBER}"
            echo "Sending Jenkins email..."

            emailext(
                to: 'roshanimulunde@gmail.com',
                subject: "PTAX Automation - ${currentBuild.currentResult} - Build #${BUILD_NUMBER}",
                body: """
PTAX Selenium Automation Execution

Job       : ${JOB_NAME}
Build     : #${BUILD_NUMBER}
Status    : ${currentBuild.currentResult}

Jenkins Build:
${BUILD_URL}

Please check Jenkins for TestNG results and screenshots.
""",
                attachLog: true
            )

            echo "Email step completed."
        }
    }
}
