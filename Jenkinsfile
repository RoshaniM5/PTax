groovy
pipeline {

    agent any

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main',
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

        always {

            echo "Publishing Allure Report..."

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
                    echo "allure-results folder not found."
                }
            }
        }

        success {

            emailext(
                to: 'roshanimulunde@gmail.com',
                subject: "SUCCESS - PTAX Automation - Build #${BUILD_NUMBER}",
                body: """
Hello Team,

PTAX Selenium Automation execution has completed successfully.

========================================
BUILD DETAILS
========================================

Job Name    : ${JOB_NAME}
Build Number: #${BUILD_NUMBER}
Status      : SUCCESS

========================================
JENKINS BUILD
========================================

${BUILD_URL}

========================================
ALLURE REPORT
========================================

${BUILD_URL}allure/

Please click the Allure Report link above to view:

- Passed tests
- Failed tests
- Skipped tests
- Test execution details
- Screenshots
- Error details
- Test execution history

Regards,
Jenkins
                """,
                attachLog: true
            )
        }

        failure {

            emailext(
                to: 'roshanimulunde@gmail.com',
                subject: "FAILED - PTAX Automation - Build #${BUILD_NUMBER}",
                body: """
Hello Team,

PTAX Selenium Automation execution has FAILED.

========================================
BUILD DETAILS
========================================

Job Name    : ${JOB_NAME}
Build Number: #${BUILD_NUMBER}
Status      : FAILED

========================================
JENKINS BUILD
========================================

${BUILD_URL}

========================================
ALLURE REPORT
========================================

${BUILD_URL}allure/

Please open the Allure Report to check:

- Failed tests
- Error details
- Screenshots
- Test execution details

The Jenkins console log is attached to this email.

Regards,
Jenkins
                """,
                attachLog: true
            )
        }
    }
}

