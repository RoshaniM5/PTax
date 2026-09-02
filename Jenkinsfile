pipeline {
 
    agent any
 
    tools {
        jdk 'JDK17'
        maven 'Maven'
    }
 
    stages {
 
        stage('Checkout Code') {
            steps {
                echo 'Pulling latest code from Git...'
                checkout scm
            }
        }
 
        stage('Build and Execute Tests') {
            steps {
                echo 'Executing Automation Tests...'
 
                bat 'mvn clean test'
            }
        }
 
        stage('Generate Test Report') {
            steps {
                script {
                    echo 'Reading TestNG Results...'
 
                    def testngReport = readFile('test-output/testng-results.xml')
 
                    def passed = (testngReport =~ /status="PASS"/).count
                    def failed = (testngReport =~ /status="FAIL"/).count
                    def skipped = (testngReport =~ /status="SKIP"/).count
                    def total = passed + failed + skipped
 
                    env.TOTAL_TESTS = total.toString()
                    env.PASSED_TESTS = passed.toString()
                    env.FAILED_TESTS = failed.toString()
                    env.SKIPPED_TESTS = skipped.toString()
 
                    echo "Total Tests: ${env.TOTAL_TESTS}"
                    echo "Passed: ${env.PASSED_TESTS}"
                    echo "Failed: ${env.FAILED_TESTS}"
                    echo "Skipped: ${env.SKIPPED_TESTS}"
                }
            }
        }
 
        stage('Publish TestNG Report') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'emailable-report.html',
                    reportName: 'Automation Test Report'
                ])
            }
        }
    }
 
    post {
 
        always {
 
            script {
 
                emailext(
                    subject: "Automation Test Report | ${env.JOB_NAME} | Build #${env.BUILD_NUMBER} | ${currentBuild.currentResult}",
 
                    mimeType: 'text/html',
 
                    body: """
<html>
<body style="font-family: Arial, sans-serif;">
 
<p>Hello Team,</p>
 
<p>The automation test execution has been completed.</p>
 
<table border="1" cellpadding="8" cellspacing="0">
<tr>
<td><b>Job Name</b></td>
<td>${env.JOB_NAME}</td>
</tr>
<tr>
<td><b>Build Number</b></td>
<td>${env.BUILD_NUMBER}</td>
</tr>
<tr>
<td><b>Build Status</b></td>
<td><b>${currentBuild.currentResult}</b></td>
</tr>
</table>
 
<br>
 
<h3>Test Execution Report</h3>
 
<table border="1" cellpadding="10" cellspacing="0">
<tr>
<th>Total Tests</th>
<th>Passed</th>
<th>Failed</th>
<th>Skipped</th>
</tr>
<tr>
<td>${env.TOTAL_TESTS}</td>
<td>${env.PASSED_TESTS}</td>
<td>${env.FAILED_TESTS}</td>
<td>${env.SKIPPED_TESTS}</td>
</tr>
</table>
 
<br>
 
<p>
<b>Jenkins Build Details:</b><br>
<a href="${env.BUILD_URL}">${env.BUILD_URL}</a>
</p>
 
<p>
Please find the complete TestNG report attached to this email.
</p>
 
<br>
 
<p>
Best Regards,<br>
<b>Roshani Mulunde</b><br>
QA Automation Engineer
</p>
 
</body>
</html>
""",
 
                    to: 'roshanimulunde.com',
 
                    attachmentsPattern: 'test-output/emailable-report.html'
                )
            }
        }
    }
}
