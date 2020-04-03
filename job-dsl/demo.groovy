pipelineJob('Test-DSL-parameterized-Child-Pipeline') {
    wrappers {
        buildName('#${BUILD_NUMBER} on ${ENV,var="BRANCH"}')
    }
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