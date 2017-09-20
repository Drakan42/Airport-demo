pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                maven {
                    mavenInstallation('myMaven')
                    goals('clean')
                    goals('compile')
                }
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                maven {
                    mavenInstallation('myMaven')
                    goals('clean')
                    goals('test')
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                maven {
                    mavenInstallation('myMaven')
                    goals('clean')
                    goals('package')
                }
            }
        }
    }
}