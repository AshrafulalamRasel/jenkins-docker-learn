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

         stage('Code Checkout') {
                               steps {
                                   checkout([$class: 'GitSCM',
                                             branches: [[name: '*/master']],
                                             doGenerateSubmoduleConfigurations: false,
                                             extensions: [],
                                             submoduleCfg: [],
                                             userRemoteConfigs: [[credentialsId: 'Git',
                                                                  url: 'https://github.com/AshrafulalamRasel/jenkins-docker-learn.git']]])
                               }

          }

         stage('Build') {
                      steps {
                        echo "Building.."
                         bat "mvn -B -DskipTests clean package"

                      }
         }

         stage('Build Docker Image') {
                      steps {
                        echo "Start To Build Project on a Docker"
                        bat "docker build -f Dockerfile -t docker-jenkins.jar ."

                      }
         }
          
        stage('Docker Image Deploy') {
                      steps {
                        echo "Start To Deploy on a Docker"
                        bat "docker-compose up -d"

                      }
         }
      }

       post {
                   success {
                       slackSend channel: 'learn-jenkins', teamDomain: 'webxgloballimited', message: "Build SUCCESSFUL - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
                   }
                   failure {
                       slackSend channel: 'learn-jenkins', teamDomain: 'webxgloballimited', message: "Build FAILED - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
                   }
                   aborted {
                       slackSend channel: 'learn-jenkins', teamDomain: 'webxgloballimited', message: "Build ABORTED - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
                   }
       }


   }
