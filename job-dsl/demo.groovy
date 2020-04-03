pipelineJob('Test-DSL-parameterized-Child-Pipeline') {
    parameters {
        stringParam('testVarJob', 'my default stringParam value', 'my description')
    }

    def repo = ${params.Git_URL}
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