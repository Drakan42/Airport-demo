pipeline {
    agent any

    stages {
        stage('Build') {
            steps{
                withMaven (maven: 'MyMaven') {
                    sh 'mvn clean compile'
                }
            }

        }
        stage('Test') {
            steps {
                echo 'Testing..'
                withMaven (maven: 'MyMaven') {
                    sh 'mvn clean test'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                withMaven (maven: 'MyMaven') {
                    sh 'mvn clean package'
                }
            }
        }
    }
}