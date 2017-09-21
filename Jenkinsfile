pipeline {
    agent any

    stages {
        stage('Build') {
            steps{
                step {
                    withMaven(
                            maven: 'myMaven',
                            mavenSettingsConfig: 'pom.xml') {
                        sh: 'mvn clean compile'
                    }
                }
            }
        }
    }
}