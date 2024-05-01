pipeline {
    agent any
    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/furkangoksu0/DockerJenkins']]
                )

            }
        }
        stage('Build docker image'){
            steps{
                script{
                    docker.build("furkangk:${env.BUILD_NUMBER}")
                }
            }
        }
        stage('Push image to Hub'){
            steps{
                script{
                    docker.image("furkangk:${env.BUILD_NUMBER}").run("-d -p 8080:8080 --name demo-container")
                }
            }
          }
 }
}