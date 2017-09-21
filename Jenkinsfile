pipeline {
    agent any

    stages {
        stage('Build') {
            withMaven (
                maven: 'myMaven',
                mavenSettingsConfig:'pom.xml',
                jdk:'8'){
                sh: 'mvn clean compile'
            }
        }
    }
}