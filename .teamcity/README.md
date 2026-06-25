# TeamCity Integration

This repository contains TeamCity Kotlin DSL settings in `settings.kts`.

## Build Configuration

- Project: `Spring Microservices Self Implementation`
- Build: `Accounts Service - Build and Test`
- Command: Maven `clean verify`
- POM: `accounts/pom.xml`
- Artifacts:
  - `accounts/target/*.jar`
  - `accounts/target/surefire-reports/*.xml`

## TeamCity Setup

1. Create a TeamCity project from this VCS repository.
2. Enable versioned settings and point TeamCity to the `.teamcity` directory.
3. Make sure the build agent has Java 21 available, because `accounts/pom.xml` sets `java.version` to `21`.
4. Run the `Accounts Service - Build and Test` configuration.
