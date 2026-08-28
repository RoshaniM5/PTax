pipeline {
agent any

```
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
        echo 'Automation execution completed.'
    }

    success {
        echo 'Automation execution completed successfully.'
    }

    failure {
        echo 'Automation execution failed. Reports will still be published.'
    }
}
}
