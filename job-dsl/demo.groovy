pipelineJob('Test-DSL-parameterized-Child-Pipeline-${env.BUILD_NUMBER}') {
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
                git(repo, 'master', { node -> node / 'extensions' << '' } )
            }
        }
    }
}