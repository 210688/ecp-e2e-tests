pipeline {
    agent {
        kubernetes {
            label "jenkins-pods-${UUID.randomUUID().toString()}"
            defaultContainer 'jnlp'
            yamlFile '.ci/pod.yaml'
        }
    }

    parameters {
        choice(name: 'ENVIRONMENT', choices: ['predprod', 'stage', 'prod'], description: 'smart-predprod, smart-stage, smart.mos')
        choice(name: 'MODULES', choices: ['ugd', 'ssr', 'mkasdprv'], description: 'Modules')
        string(name: 'WEB_MOBILE_DEVICE', defaultValue: 'iPhone X', description: 'Web mobile device')
        string(name: 'WEB_THREADS', defaultValue: '6', description: 'Web threads count')
        string(name: 'ANDROID_DEVICE', defaultValue: 'Samsung Galaxy Note 10', description: 'Android device')
        string(name: 'ANDROID_VERSION', defaultValue: '9.0', description: 'Android version')
        string(name: 'ANDROID_BS_APP', defaultValue: 'bs://772572969bb93fee52cedce59fd3ab9e587262de', description: 'Android browserstack app')
        string(name: 'IOS_DEVICE', defaultValue: 'iPhone XS Max', description: 'iOS device')
        string(name: 'IOS_VERSION', defaultValue: '12', description: 'iOS version')
        string(name: 'IOS_BS_APP', defaultValue: 'bs://a82fb8c09da1445b5590be0b89d40b96fa193180', description: 'iOS browserstack app')
        choice(name: 'DEBUG', choices: ['', '_smoke', "_failed"], description: 'debug, smoke - 1 test for platform / failed - 1 failed test')
        string(name: 'UPSTREAM_BRANCH_NAME', defaultValue: '', description: 'debug, UPSTREAM_BRANCH_NAME')
        string(name: 'UPSTREAM_BUILD_URL', defaultValue: '', description: 'debug, UPSTREAM_BUILD_URL')
        string(name: 'UPSTREAM_BUILD_NUMBER', defaultValue: '', description: 'debug, UPSTREAM_BUILD_NUMBER')
    }

    environment {
        LABEL = "jenkins-pods-${UUID.randomUUID().toString()}"
        MOON = "moon.moon"
        WEB_DESKTOP_EMPLOYER_URL = "web.dev.jobtoday.com"
        VIDEO_URL = "jobtoday-ui-tests-recordings.s3-eu-west-1.amazonaws.com"
        ALLURE_RESULTS = 'build/allure-results/'
    }


    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages {
        stage('Run web desktop tests 1') {
            when {
                environment name: 'PLATFORM', value: 'web_desktop'
            }
            steps {
                container('gradle') {
                    sh "gradle web_desktop${params.DEBUG} -Dweb_url=${params.WEB_URL} -Dweb_mobile_device=\"\" -Pweb_threads=${params.WEB_THREADS} -Dselenoid=true -Dselenoid_url=${env.MOON} -Dvideo=true -Dvideo_url=${env.VIDEO_URL} -Pallure_results=\"${env.ALLURE_RESULTS}${env.PLATFORM}\""
                }
            }
        }
        stage('Run web mobile tests 2'){
            when {
                environment name: 'PLATFORM', value: 'web_mobile'
            }
            steps {
                container('gradle') {
                    sh "gradle web_mobile${params.DEBUG} -Dweb_url=${params.WEB_URL} -Dweb_mobile_device=\"${params.WEB_MOBILE_DEVICE}\" -Pweb_threads=${params.WEB_THREADS} -Dselenoid=true -Dselenoid_url=${env.MOON} -Dvideo=true -Dvideo_url=${env.VIDEO_URL} -Pallure_results=\"${env.ALLURE_RESULTS}${env.PLATFORM}\""
                }
            }
        }
        stage('Run web desktop employer tests') {
            when {
                environment name: 'PLATFORM', value: 'web_desktop_employer'
            }
            steps {
                container('gradle') {
                    sh "gradle web_desktop_employer${params.DEBUG} -Dweb_url=${env.WEB_DESKTOP_EMPLOYER_URL} -Dweb_mobile_device=\"\" -Pweb_threads=${params.WEB_THREADS} -Dselenoid=true -Dselenoid_url=${env.MOON} -Dvideo=true -Dvideo_url=${env.VIDEO_URL} -Pallure_results=\"${env.ALLURE_RESULTS}${env.PLATFORM}\""
                }
            }
        }
        stage('Run android tests'){
            when {
                environment name: 'PLATFORM', value: 'android'
            }
            steps {
                container('gradle') {
                    sh "gradle android${params.DEBUG} -Dmobile_device=\"${params.ANDROID_DEVICE}\" -Dmobile_version=\"${params.ANDROID_VERSION}\" -Dbs_app=\"${params.ANDROID_BS_APP}\" -Dbs_app=\"${params.ANDROID_BS_APP}\" -Dbuild_number=${BUILD_NUMBER} -Djob_base_name=${JOB_BASE_NAME} -Pallure_results=\"${env.ALLURE_RESULTS}${env.PLATFORM}\" -Dvideo=true"
                }
            }
        }
        stage('Run ios tests'){
            when {
                environment name: 'PLATFORM', value: 'ios'
            }
            steps {
                container('gradle') {
                    sh "gradle ios${params.DEBUG} -Dmobile_device=\"${params.IOS_DEVICE}\" -Dmobile_version=\"${params.IOS_VERSION}\" -Dbs_app=\"${params.IOS_BS_APP}\" -Dbuild_number=${BUILD_NUMBER} -Djob_base_name=${JOB_BASE_NAME} -Pallure_results=\"${env.ALLURE_RESULTS}${env.PLATFORM}\" -Dvideo=true"
                }
            }
        }
        stage('Run api tests'){
            when {
                environment name: 'PLATFORM', value: 'api'
            }
            steps {
                container('gradle') {
                    sh "gradle api -Dbuild_number=${BUILD_NUMBER} -Djob_base_name=${JOB_BASE_NAME} -Pallure_results=\"${env.ALLURE_RESULTS}${env.PLATFORM}\""
                }
            }
        }
    }

    post {
        always {
            script {
                allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'build/allure-results/**']]
                ])
            }
        }
        failure {
            script {
                def summary = junit testResults: 'build/test-results/**/*.xml'
                def upstream_line = ""
                def bs_build_line = ""
                def message_color = "#0000FF"
                if(env.UPSTREAM_BRANCH_NAME != "") {
                    message_color = "#FF0000"
                    upstream_line = "\n*Upstream build* (${env.UPSTREAM_BRANCH_NAME}): <${env.UPSTREAM_BUILD_URL}|#${env.UPSTREAM_BUILD_NUMBER}>"
                }
                if(env.PLATFORM == "ios" || env.PLATFORM == "android") {
                    sh "echo  ${env.PLATFORM}"
                    def bs_build_url = getBSBuildUrl()
                    bs_build_line = "\n*Browserstack build*: <${bs_build_url}|link>"
                }

                def slackCommand = "TITLE='Build failed' COLOR='${message_color}' slack-message '#test-notifications' " +
                        "'*Platform:* ${env.PLATFORM} \n" +
                        "<${env.BUILD_URL}allure|Allure report> " +
                        "(*Passed:* ${summary.passCount} " +
                        "*Failures:* ${summary.failCount} " +
                        "*Skipped:* ${summary.skipCount}) \n" +
                        "*Jenkins build* (${env.BRANCH_NAME}): <${env.BUILD_URL}|#${env.BUILD_NUMBER}> " +
                        "${upstream_line}" +
                        "${bs_build_line}'"

                container("notifications") {
                    sh slackCommand
                }
            }
        }
    }
}

@NonCPS

def getBSBuildUrl() {
    def matcher = manager.getLogMatcher(".*bs_build_url: (\\w.+).*")
    if (matcher.matches()) {
        return (matcher.group(1))
    }

    return ""
}


