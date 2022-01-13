pipeline {
    agent any

    stages {
        stage("Compile") {
            steps {
                sh "./mvnw clean compile -e"    
            }
        }
        stage("Sonar"){
            steps {
                script {
                    def scannerHome = tool 'sonar-scanner';
                    withSonarQubeEnv('sonarcube-server') { // If you have configured more than one global server connection, you can specify its name
                        sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=ejemplo-maven -Dsonar.java.binaries=build"
                    }
                }
            }
        }
        stage("Test") {
            steps {
                sh "./mvnw clean test -e"    
            }
        }
        stage("Package") {
            steps {
                sh "./mvnw clean package -e"    
            }
        }
        stage("Run") {
            steps {
                sh "nohup bash mvnw spring-boot:run &"
                sleep 20
            }
        }
        stage("Test-app") {
            steps {
                sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=porfin'"
            }
        }
    }
}
