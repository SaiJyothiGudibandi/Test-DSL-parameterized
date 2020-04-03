pipelineJob('Test-DSL-parameterized-Child-Pipeline') {

    parameters {
        stringParam( "testVarJob", "Test-variable" )
    }

    def repo = 'https://github.com/SaiJyothiGudibandi/Test-sample-project-maven.git'
    
    definition {
        cpsScm {
          scm {
            git(repo, 'master', scriptPath('Jenkinsfile$testVarJob'){ node -> node / 'extensions' << '' } )
            }
        }
    }
}
