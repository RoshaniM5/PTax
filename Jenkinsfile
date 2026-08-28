pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'YOUR_GITHUB_REPOSITORY_URL'
            }
        }

        stage('Check Workspace') {
            steps {
                bat '''
                    echo Current Directory:
                    cd

                    echo.
                    echo Workspace Files:
                    dir

                    echo.
                    echo Checking pom.xml:
                    if exist pom.xml (
                        echo pom.xml FOUND
                    ) else (
                        echo pom.xml NOT FOUND
                    )
                '''
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
            echo "======================================"
            echo "BUILD RESULT = ${currentBuild.currentResult}"
            echo "BUILD NUMBER = ${BUILD_NUMBER}"
            echo "Sending Jenkins email..."
            echo "======================================"

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

Build Number : ${BUILD_NUMBER}
Build Status : ${currentBuild.currentResult}
""",
                attachLog: true
            )

            echo "Email step completed."
        }
    }
}

