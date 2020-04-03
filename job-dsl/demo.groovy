pipelineJob('Test-DSL-parameterized-Child-Pipeline') {
    parameters {
        stringParam('testVarJob', 'my default stringParam value', 'my description')
    }

    def repo = 'https://github.com/SaiJyothiGudibandi/Test-sample-project-maven.git'
    triggers {
        scm('*/15 * * * *')
    }
    definition {
        cpsScm {
            scm {
                git(${params.Git_URL}, ${params.Branch_Name}, { node -> node / 'extensions' << '' } )
            }
        }
    }
}