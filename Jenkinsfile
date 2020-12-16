pipeline {
    agent any
    choice(name: 'HERRAMIENTA', choices: ['gradle', 'maven'], description: 'opcion de compilacion')

    stages {
        stage('Pipeline') {
            steps {
                script {
                //segun el valor del parametro se debe llamar a gradle o maven
                echo "HERRAMIENTA SELECCIONADA: ${params.HERRAMIENTA}"                                
                if (params.HERRAMIENTA == 'gradle'){
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
}
