pipelineJob('Test-DSL-parameterized-Child-Pipeline') {
    parameters {
        stringParam('testVarJob', 'Sample test variable from Config Job parameters', 'my description')
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
