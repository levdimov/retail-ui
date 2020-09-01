package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.BuildType
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, create a buildType with absolute id = 'Common_ReactSorge_Test'
in the project with absolute id = 'Common_ReactSorge', and delete the patch script.
*/
create(AbsoluteId("Common_ReactSorge"), BuildType({
    id = AbsoluteId("Common_ReactSorge_Test")
    name = "List/Test"

    vcs {
        root(AbsoluteId("Common_ReactSorge_HttpsGithubComSkbkonturReactSorgeGitRefsHeadsMaster"))
    }

    steps {
        step {
            name = "Install"
            type = "jonnyzzz.npm"
            param("npm_commands", "install")
        }
        step {
            name = "Lint"
            type = "jonnyzzz.npm"
            param("npm_commands", "lint")
        }
        script {
            name = "Debug (run dev-server)"
            scriptContent = """
                start /b npm run debug
                ping 127.0.0.1 -n 11
            """.trimIndent()
        }
        step {
            name = "Test"
            type = "jonnyzzz.npm"
            param("npm_commands", "run test")
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        commitStatusPublisher {
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = password {
                    userName = "lossir"
                    password = "credentialsJSON:33f35deb-8984-4a40-b0f0-8b8d51306dee"
                }
            }
        }
    }
}))

