pipeline {
    agent any
    parameters { choice(name: 'HERRAMIENTA', choices: ['gradle', 'maven'], description: 'opcion de compilacion')}
    stages {
        stage('Pipeline') {
            steps {
                script {
                //segun el valor del parametro se debe llamar a gradle o maven
                env.TAREA = ''
                echo "HERRAMIENTA SELECCIONADA: ${params.HERRAMIENTA}"   
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"                             
                if (params.HERRAMIENTA == 'gradle'){
                        //slackSend "Build Started"
                    	def ejecucion = load 'gradle.groovy'
	                    ejecucion.call()
                } else {
                    	def ejecucion = load 'maven.groovy'
	                    ejecucion.call()                    
                }

                }
            }
        }
    }

    post {
        success{
            println env.TAREA
        }

        failure{
            println env.TAREA
        }
    }

}
