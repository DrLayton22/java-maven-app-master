def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.6'  // Asegúrate de que esta herramienta esté configurada en Jenkins
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    gv.buildJar()  // Llamamos la función buildJar de script.groovy
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    gv.buildImage()  // Llamamos la función buildImage de script.groovy
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    gv.deployApp()  // Llamamos la función deployApp de script.groovy
                }
            }
        }
    }   
}
