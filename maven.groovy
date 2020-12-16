/*
	forma de invocación de método call:
	def ejecucion = load 'script.groovy'
	ejecucion.call()
*/

def call(){
  
      stage('Compile Code') {
                sh 'mvn clean compile -e'
        }
        stage('Test Code') {           
                sh 'mvn clean test -e'
        }
        stage('Jar ') {             
                sh 'mvn clean package -e' 
        }
        stage('SonarQube analysis') {
             withSonarQubeEnv(installationName: 'sonar-server') { 
             sh 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
          }
        }
        stage('Upload Nexus') {            
                nexusPublisher nexusInstanceId: 'nexus', nexusRepositoryId: 'test-nexus', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: 'jar', filePath: '/Users/servidorcasa/Documents/Cursos/2020_devops/ejemplo_maven_24_11_2020/ejemplo-maven/build/DevOpsUsach2020-0.0.1.jar']], mavenCoordinate: [artifactId: 'DevOpsUsach2020', groupId: 'com.devopsusach2020', packaging: 'jar', version: '3.0.1']]]
        } 

}

return this;