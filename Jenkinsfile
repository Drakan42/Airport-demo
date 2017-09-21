pipeline {
    agent any

    stages {
        stage('Build') {
            step{
                withMaven (
                    maven: 'myMaven',
                    mavenSettingsConfig:'pom.xml') {
                    sh: 'mvn clean compile'
                }
            }
        }
    }
}