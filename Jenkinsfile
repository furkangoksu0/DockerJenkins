pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/furkangoksu0/DockerJenkins']]
                )
                bat 'mvn clean install'
            }
        }
        stage('Stop and Remove Existing Container') {
            steps {
              script {

                    bat 'docker stop demo-container '
                    bat 'docker rm demo-container'
                }
            }
           }


        stage('Build docker image'){
            steps{
                script{
                    docker.build("furkangoksu0/app:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('Push image to Hub'){
            steps{
              script{
                  docker.image("furkangoksu0/app:${env.BUILD_NUMBER}").run("-d -p 6580:6580 --name demo-container")
              }
            }
        }

    }

}