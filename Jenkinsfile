pipeline {
    agent any
    stages {
        stage('Compile') {
            steps {
                sh "./mvnw clean compile -e"    
            }
        }
        stage('Test') {
            steps {
                sh "./mvnw clean test -e"    
            }
        }
        stage('package') {
            steps {
                sh "./mvnw clean package -e"    
            }
        }
        stage('run') {
            steps {
                sh "nohup bash mvnw spring-boot:run &"
                sleep 20
            }
        }
        stage('test-app') {
            steps {
                sh "curl -X GET 'http://localhost:8081/rest/mscovid/test?msg=porfin'"
            }
        }
    }
}
