pipeline {
    agent any

    stages {
        stage('Build') {
            steps{
                withMaven (maven: 'myMaven') {
                    sh 'mvn clean compile'
                }
            }
        }
    }
}