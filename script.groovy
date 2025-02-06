def buildJar() {
    echo "building the application..."
    sh 'mvn package'  // Usamos Maven para empaquetar el proyecto
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t nanajanashia/demo-app:jma-2.0 .'  // Construimos la imagen Docker
        sh "echo $PASS | docker login -u $USER --password-stdin"  // Login en Docker Hub
        sh 'docker push nanajanashia/demo-app:jma-2.0'  // Subimos la imagen a Docker Hub
    }
} 

def deployApp() {
    echo 'deploying the application...'
    // Aquí puedes agregar el código necesario para desplegar la aplicación
    // Por ejemplo, invocar un Kubernetes o un comando de Docker para ejecutar el contenedor.
} 

return this
