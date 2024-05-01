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
                                   // Varolan container'ı durdur ve sil
                                            bat 'docker stop furkangk '
                                            bat 'docker rm furkangk'
                                        }
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
                    docker.image("furkangk:${env.BUILD_NUMBER}").run("-d -p 4444:4444 --name furkangk")
                }
            }
        }
    }

}