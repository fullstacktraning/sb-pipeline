pipeline {
    agent any

    stages {

        stage('Clone Repository') {
            steps {
                git branch: 'main',
                url: 'https://github.com/fullstacktraning/sb-pipeline.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t springboot-app .'
            }
        }

        stage('Stop Old Container') {
            steps {
                sh 'docker stop springboot-container || true'
                sh 'docker rm springboot-container || true'
            }
        }

        stage('Run New Container') {
            steps {
                sh '''
                docker run -d -p 8000:8000 \
                --name springboot-container \
                -e DB_URL=$DB_URL \
                -e DB_USERNAME=$DB_USERNAME \
                -e DB_PASSWORD=$DB_PASSWORD \
                -e MAIL_USERNAME=$MAIL_USERNAME \
                -e MAIL_PASSWORD=$MAIL_PASSWORD \
                -e JWT_SECRET=$JWT_SECRET \
                -e AWS_ACCESS_KEY=$AWS_ACCESS_KEY \
                -e AWS_SECRET_KEY=$AWS_SECRET_KEY \
                -e AWS_REGION=$AWS_REGION \
                -e AWS_BUCKET=$AWS_BUCKET \
                springboot-app
                '''
            }
        }
    }
}
