pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                withMaven (
                    maven: 'myMaven',
                    sh: 'clean compile'
                )
            }
        }

    }
}