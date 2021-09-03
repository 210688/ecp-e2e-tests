pipeline {

    agent any
    stages {

        stage('checkout') {
            steps{
                checkout scm [$class: 'GitSCM', branches: [[name: '*/regresing_tests']], userRemoteConfigs:
                [[credentialsId: 'reinform-cdp-common-git', url: 'http://smart.mos.ru/git/autotest/ecp-e2e-tests.git']])
            }
        }

        stage('Build') {
            steps{
            build job: 'Regressions', parameters: [string(name: 'ENVIRONMENT', value: 'prod'), string(name: 'ALLURE_NOTIFICATIONS_VERSION', value: '3.1.1')]
                //sh 'mkdir gradle'
                //sh 'cd gradle/ ; wget https:// github.com/gradle/gradle/blob/master/gradle/wrapper/gradle-wrapper.jar'
                //sh "./gradlewrapper -Dmaven.test.failure.ignore=true clean package"
                }
    }
}
}