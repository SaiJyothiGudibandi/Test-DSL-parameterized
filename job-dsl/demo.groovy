pipelineJob('Test-DSL-parameterized-Child-Pipeline') {
    parameters {
        string defaultValue: 'Test-value', description: 'creating a variable for testing purpose', name: 'testVarJob', trim: false
    }


    def repo = 'https://github.com/SaiJyothiGudibandi/Test-sample-project-maven.git'
    triggers {
        scm('*/15 * * * *')
    }
    definition {
        cpsScm {
            scm {
                git(repo, 'master', { node -> node / 'extensions' << '' } )
            }
        }
    }
}