import com.petclinic.Shared;

def call(actionList = [:]) {
    def shared = new Shared(this)

    pipeline {
        agent any

        tools {
            jdk 'java-17'
            maven 'maven-3.9.1'
        }

        stages {
            stage('Build') {
                steps {
                    echo 'Building..'
                    sh("mvn --version")
                    sh("chmod +x build.sh")
                    sh("./build.sh")
                }
            }
            stage('Deploy') {
             when { branch "main" }
                steps {
                    echo 'Deploying....'
                    sh("chmod +x deploy.sh")
                    sh("./deploy.sh")
                }
            }
        }
    }

}