pipeline {
    agent any

//small changes
     triggers {
             // Every 5 min
             pollSCM 'H/5 * * * *'
      }

     tools {
        maven 'maven_default'
     }

    stages {

      stage('Compile stage') {
                 steps {
                     bat "mvn clean compile"
                 }
       }

      stage('Build info') {

                steps {
                    echo "Running build: ${env.BUILD_ID} on ${env.JENKINS_URL}"
                    slackSend channel: 'learn-jenkins', teamDomain: 'webxgloballimited', message: "Build Started - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
                }
     }
    }
}
