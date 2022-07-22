node {
    ansiColor('xterm') {
        // some block
    }
    stage('get code') {
        git branch: 'develop', credentialsId: 'github_credentials', url: 'https://github.com/nnson0310/phptravel_cucumber_java_automation_framework'
    }
    stage('compile and build') {
        bat 'mvn clean'
    }
    stage("run test") {
        bat 'mvn test -Dbrowser=%browser% -Denv=%env%'
    }
    stage('Print status build') {
        echo 'Build done'
    }
}