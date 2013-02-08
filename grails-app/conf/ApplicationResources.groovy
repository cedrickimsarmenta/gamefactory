modules = {
    application {
        resource url:'js/application.js'
    }
    core{
        dependsOn 'jquery'
   }
}