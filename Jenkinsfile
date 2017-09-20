pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                withMaven (
                    maven: 'myMaven',
                    mavenSettingsConfig:'pom.xml',
                    sh: 'clean compile'
                )
            }
        }
    }
}