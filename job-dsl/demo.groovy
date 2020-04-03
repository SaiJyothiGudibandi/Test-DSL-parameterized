pipelineJob('Test-DSL-parameterized-Child-Pipeline') {

    parameters {
        stringParam( "testVarJob", "Test-variable-value", "value1" )
    }


    def repo = 'https://github.com/SaiJyothiGudibandi/Test-sample-project-maven.git'
    triggers {
        scm('*/15 * * * *')
    }
    sh "echo $testVarJob"
    definition {
        cpsScm {
            scm {
                git(repo, 'master', { node -> node / 'extensions' << '' } )
            }
        }
    }
}