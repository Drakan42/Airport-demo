pipeline {
    agent any

    stages {
        stage('Build') {
            steps{
                withMaven (
                    maven: 'myMaven',
                    mavenSettingsConfig:'pom.xml') {
                    sh: 'mvn clean compile'
                }
            }
        }
    }
}