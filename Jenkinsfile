pipeline { 
    agent any 

    environment { 
        // Define environment variable 
        // Jenkins credentials configuration 
        DOCKER_HUB_CREDENTIALS = credentials('dockerhub_credentials') // Docker Hub credentials ID stored in Jenkins 
        // Docker Hub Repository's name 
        DOCKER_IMAGE = 'abcee/teedy-app' // Your Docker Hub user name and repository's name 
        DOCKER_TAG = "${env.BUILD_NUMBER}" // Use build number as tag 
    } 

    stages { 
        stage('Build') { 
            steps { 
                checkout scmGit( 
                    branches: [[name: 'jenkins/docker']],  
                    extensions: [],  
                    userRemoteConfigs: [[url: 'https://github.com/fest6/Teedy.git']] // Your GitHub repository 
                ) 
                sh 'mvn -B -DskipTests clean package' 
            } 
        } 

        // Building Docker images 
        stage('Building image') { 
            steps { 
                script { 
                    // Assume Dockerfile is located at root  
                    docker.build("${env.DOCKER_IMAGE}:${env.DOCKER_TAG}") 
                } 
            } 
        } 

        // Uploading Docker images into Docker Hub 
        stage('Upload image') { 
            steps { 
                script { 
                    // Sign in to Docker Hub 
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub_credentials') { 
                        // Push image 
                        docker.image("${env.DOCKER_IMAGE}:${env.DOCKER_TAG}").push() 
                        // Optional: label latest 
                        docker.image("${env.DOCKER_IMAGE}:${env.DOCKER_TAG}").push('latest') 
                    } 
                } 
            } 
        } 

        // Running Docker container 
        stage('Run containers') { 
            steps { 
                script { 
                    // Stop then remove containers if they exist 
                    sh 'docker stop teedy-container-8081 || true' 
                    sh 'docker rm teedy-container-8081 || true' 
                    // Run container 
                    docker.image("${env.DOCKER_IMAGE}:${env.DOCKER_TAG}").run('--name teedy-container-8081 -d -p 8081:8080') 
                    // Optional: list all teedy-containers 
                    sh 'docker ps --filter "name=teedy-container"' 
                } 
            } 
        } 
    } 
}
