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
            echo 'Sending automation email...'

            emailext(
                to: 'roshanimulunde@gmail.com',
                subject: "PTAX Selenium Automation - ${currentBuild.currentResult} - Build #${BUILD_NUMBER}",
                mimeType: 'text/html',
                attachLog: true,

                attachmentsPattern: '**/target/surefire-reports/*.xml, **/target/screenshots/**/*',

                body: """
                    <html>
                    <body>

                    <h2>PTAX Selenium Automation Report</h2>

                    <table border="1" cellpadding="8" cellspacing="0">

                        <tr>
                            <td><b>Job Name</b></td>
                            <td>${env.JOB_NAME}</td>
                        </tr>

                        <tr>
                            <td><b>Build Number</b></td>
                            <td>#${env.BUILD_NUMBER}</td>
                        </tr>

                        <tr>
                            <td><b>Status</b></td>
                            <td>${currentBuild.currentResult}</td>
                        </tr>

                    </table>

                    <br>

                    <p>
                        Selenium/TestNG automation execution has completed.
                    </p>

                    <p>
                        <a href="${env.BUILD_URL}">
                            Open Jenkins Build
                        </a>
                    </p>

                    <p>
                        TestNG results and screenshots are attached where available.
                    </p>

                    </body>
                    </html>
                """
            )
        }

        success {
            echo 'Automation completed successfully and email was sent.'
        }

        failure {
            echo 'Automation failed, but email and reports were processed.'
        }
    }
}
