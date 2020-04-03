pipelineJob('Test-DSL-parameterized-Jenkins') {
    parameters {
        string(defaultValue: "Testing", description: 'Testing variable', name: 'testvar1')
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
