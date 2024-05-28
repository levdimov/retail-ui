package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with id = 'Validations_Storybook'
in the project with id = 'Validations', and delete the patch script.
*/
create(RelativeId("Validations"), BuildType({
    id("Validations_Storybook")
    name = "Storybook"

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        vcs {
            id = "VCS_TRIGGER"
            branchFilter = "+:refs/tags/@skbkontur/react-ui@*"
        }
    }
    
    disableSettings("COMMIT_STATUS_PUBLISHER", "PULL_REQUESTS")
}))

