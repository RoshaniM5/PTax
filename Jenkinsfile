pipeline {
    agent any

    stages {

        stage('Build & Test') {
            steps {
                echo 'Running PTAX Selenium automation...'

                catchError(
                    buildResult: 'FAILURE',
                    stageResult: 'FAILURE'
                ) {
                    bat 'mvn clean test'
                }
            }
        }

        stage('Publish TestNG Results') {
            steps {
                echo 'Publishing TestNG results...'

                junit(
                    testResults: '**/target/surefire-reports/*.xml',
                    allowEmptyResults: true
                )
            }
        }

        stage('Archive Reports') {
            steps {
                echo 'Archiving reports and screenshots...'

                archiveArtifacts(
                    artifacts: '**/target/surefire-reports/**/*, **/target/screenshots/**/*',
                    allowEmptyArchive: true
                )
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
