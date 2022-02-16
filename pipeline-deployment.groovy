pipeline {
    agent any
    options {
        disableConcurrentBuilds()
        buildDiscarder(logRotator(numToKeepStr: '10'))
    }

    stages{
        stage('Import Job DSL') {
            options { timeout (time: 1, unit: 'MINUTES') }
            steps {
                checkout scm: [$class: 'GitSCM', userRemoteConfigs: [[url: "https://github.com/calavelas/job-dsl"]], branches: [[name: 'main']]], poll: false
            }
        }
        stage('Run Job DSL') {
            options { timeout (time: 5, unit: 'MINUTES') }
            steps {
                script {
                    sh 'ls -la'
                    def inputFile = readFile 'job-dsl-redesign'
                    jobDsl scriptText: inputFile                    
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
