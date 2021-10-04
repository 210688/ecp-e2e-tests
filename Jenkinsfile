user_list = [
        "stage":[ "soldatovks", "frolenkovda" ],
        "predprod":[ "soldatovks" ],
        "prod":[ "soldatovks" ]
]

pipeline {
    agent {
        node {
            label 'autotests-agent';
        }
    }
    parameters {
        choice(
                name: 'ENVIRONMENT',
                choices: ['predprod', 'prod', 'stage'],
                description: 'smart-predprod.mos.ru - predprod\nsmart.mos.ru - prod\nsmart-stage.mos.ru - stage');
        choice(
                name: 'MODULES',
                choices: ['ugd', 'ssr', 'mkasdprv'],
                description: '');
        string(
                name: 'ALLURE_NOTIFICATIONS_VERSION',
                defaultValue: '3.1.1',
                description: '' );
    }
    tools {
        gradle 'gradle 6.6-rc-1'
    }
    stages {
        stage('Build') {
            steps {
                script {
                    println "allure-notifications-${ALLURE_NOTIFICATIONS_VERSION.trim()}.jar"
                    println  !fileExists("${WORKSPACE}/allure-notifications-${ALLURE_NOTIFICATIONS_VERSION.trim()}.jar")
                    sh "ls -lah allure-notifications-${ALLURE_NOTIFICATIONS_VERSION.trim()}.jar"
                    git branch: 'master', credentialsId: 'reinform-cdp-common-git', url: 'http://smart.mos.ru/git/autotest/ecp-e2e-tests.git'
                    withAllureUpload(name: '${JOB_NAME} - #${BUILD_NUMBER}', projectId: '', results: [[path: 'build/allure-results']], serverId: 'allure', tags: '') {
                        httpRequest responseHandle: 'NONE', url: 'http://10.15.58.218:4444/status', wrapAsMultipart: false
                        if(ALLURE_USERNAME in user_list[ENVIRONMENT]){
                            println "Сборка автотестов запущена";
                            sh 'gradle clean regressing -Dtag=${MODULES} -Denvironment=${ENVIRONMENT} -Dremote_driver_url=http://10.15.58.218:4444/wd/hub';
                            allure includeProperties: false, jdk: '', results: [[path: 'build/allure-results']]

                        } else {
                            println "Вам, запрещено запускать сборку обратитесь пожалуйста к @amidosha или @iTerkin посредством телеграмма";
                        }
                    }
                }
            }
        }
    }
    post {
        success {
            script {
                if ( !fileExists("allure-notifications-${ALLURE_NOTIFICATIONS_VERSION}.jar")){
                    sh "wget https://github.com/qa-guru/allure-notifications/releases/download/${ALLURE_NOTIFICATIONS_VERSION}/allure-notifications-${ALLURE_NOTIFICATIONS_VERSION}.jar";
                }
                sh """
                java  \
                "-DprojectName=тесты на платформе *mos.ru" \
                "-Denv=${ENVIRONMENT}" \
                "-DreportLink=${BUILD_URL}" \
                "-Dconfig.file=src/test/resources/config/telegram.json" \
                -jar ../allure-notifications-${ALLURE_NOTIFICATIONS_VERSION}.jar 
                """;
            }
        }
    }
}