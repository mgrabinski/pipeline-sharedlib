def call(Map pipelineParams) 
{
    pipeline 
    {
        agent any
        stages 
        {
            stage('Build') 
            {
                steps 
                {
                    echo "Hello, ${pipelineParams.firstname}, from Build"
                }
            }
            stage('Test') 
            {
                steps 
                {
                    echo "Testing Testing 123, Mr. ${pipelineParams.lastname}"
                }
            }
            stage('Integration Test') 
            {
                steps 
                {
                    echo 'Integration Testing Testing 666'
                }
            }
            stage('Deploy') 
            {
                steps 
                {
                    echo 'Deploy some things'
                    step([$class: 'CordellWalkerRecorder'])
                    
                    emailext subject: '$DEFAULT_SUBJECT',
                                body: '$DEFAULT_CONTENT',
                                //body: '$DEFAULT_CONTENT',
                                replyTo: '$DEFAULT_REPLYTO',
                                //attachmentsPattern: 'reports/*.zip',
                                to: "ralph.nuesse@compuware.com"
                    

                }
            }
        }
    }
}