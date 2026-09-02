```groovy
pipeline {

    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/RoshaniM5/PTax.git'
            }
        }

        stage('Check Workspace') {
            steps {
                bat '''
                    echo ======================================
                    echo Current Directory
                    echo ======================================
                    cd

                    echo.
                    echo ======================================
                    echo Workspace Files
                    echo ======================================
                    dir

                    echo.
                    echo ======================================
                    echo Checking pom.xml
                    echo ======================================

                    if exist pom.xml (
                        echo pom.xml FOUND
                    ) else (
                        echo pom.xml NOT FOUND
                        exit /b 1
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
            echo "Publishing Allure Report"
            echo "======================================"

            script {
                if (fileExists('allure-results')) {

                    allure([
                        includeProperties: false,
                        jdk: '',
                        results: [
                            [path: 'allure-results']
                        ]
                    ])

                } else {
                    echo "allure-results folder not found. Skipping Allure report."
                }
            }

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

        success {
            echo "======================================"
            echo "Selenium Automation PASSED"
            echo "======================================"
        }

        failure {
            echo "======================================"
            echo "Selenium Automation FAILED"
            echo "======================================"
        }
    }
}
```
