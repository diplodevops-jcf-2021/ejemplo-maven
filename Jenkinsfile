pipeline {
    agent any

    stages {
        stage("Compile") {
            steps {
                sh "./mvnw clean compile -e"    
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
                sh "curl -X GET 'http://localhost:8181/rest/mscovid/test?msg=porfin'"
            }
        }
        stage("nexus"){
            steps{
                nexusPublisher nexusInstanceId: 'server-nexus',
                nexusRepositoryId: 'maven_M3S10',
                packages: [
                    [
                        $class: 'MavenPackage',
                        mavenAssetList: [
                            [classifier: '', extension: '', filePath: "${env.WORKSPACE}/build/DevOpsUsach2020-0.0.1.jar"]
                        ],
                        mavenCoordinate: [
                            artifactId: 'DevOpsUsach2020',
                            groupId: 'com.devopsusach2020',
                            packaging: 'jar',
                            version: '0.0.1'
                        ]
                    ]
                ]
            }
        }
    }
}
