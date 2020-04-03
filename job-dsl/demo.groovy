pipelineJob('Test-DSL-parameterized-Child-Pipeline') {
    parameters {
        string(defaultValue: ${params.$testvar}, description: 'Testing variable', name: 'testvar1')
    }

    def repo = 'https://github.com/SaiJyothiGudibandi/sample-project-maven.git'
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
