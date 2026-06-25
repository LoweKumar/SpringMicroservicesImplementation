import jetbrains.buildServer.configs.kotlin.BuildType
import jetbrains.buildServer.configs.kotlin.DslContext
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

version = "2024.12"

project {
    id("SpringMicroservicesSelfImpln")
    name = "Spring Microservices Self Implementation"

    buildType(AccountsServiceBuild)
}

object AccountsServiceBuild : BuildType({
    id("AccountsServiceBuild")
    name = "Accounts Service - Build and Test"
    description = "Builds and verifies the accounts Spring Boot microservice with Maven."

    vcs {
        root(DslContext.settingsRoot)
        cleanCheckout = true
    }

    artifactRules = """
        accounts/target/*.jar => accounts-service
        accounts/target/surefire-reports/*.xml => test-reports
    """.trimIndent()

    steps {
        maven {
            name = "Maven clean verify"
            goals = "clean verify"
            pomLocation = "accounts/pom.xml"
            runnerArgs = "-B"
        }
    }

    triggers {
        vcs {
            branchFilter = "+:*"
        }
    }

    features {
        perfmon {
        }
    }
})
