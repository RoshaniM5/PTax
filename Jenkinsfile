```groovy
pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/RoshaniM5/PTax.git'
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

        stage('Publish Allure Report') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    results: [[path: 'target/allure-results']]
                ])
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

========================================
JENKINS BUILD
========================================

${BUILD_URL}

========================================
ALLURE REPORT
========================================

${BUILD_URL}allure/

Please open the Allure Report link above to view:
- Passed tests
- Failed tests
- Skipped tests
- Test execution details
- Screenshots
- Error details

Build Number : ${BUILD_NUMBER}
Build Status : ${currentBuild.currentResult}

========================================
""",

                attachLog: true
            )

            echo "Email step completed."
        }
    }
}
```
