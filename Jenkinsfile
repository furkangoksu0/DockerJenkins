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
                  docker.image("furkangoksu0/app:${env.BUILD_NUMBER}").run("-d -p 8085:8085 --name demo-container")
              }
            }
        }

    }

}