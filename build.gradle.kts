plugins {
    id("java")
    id("org.sonarqube") version "4.4.1.3373"
    id("jacoco")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:3.11.2")
    testImplementation("org.powermock:powermock-core:2.0.9")
    testImplementation("org.powermock:powermock-module-junit4:2.0.9")
    testImplementation("org.powermock:powermock-api-mockito2:2.0.9")
    testImplementation("org.mockito:mockito-inline:3.11.2")
    implementation("commons-io:commons-io:2.8.0")
}

tasks.test {
    useJUnitPlatform()
}

jacoco {
    toolVersion = "0.8.7"
}

tasks.named("jacocoTestReport") {
    dependsOn("test")
}

sonar {
    properties {
        property("sonar.projectKey", "StendenStudentHub_JabberTestV3")
        property("sonar.organization", "stendenstudenthub")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.coverage.jacoco.xmlReportPaths", "build/reports/jacoco/test/jacocoTestReport.xml")
    }
}

// Customize the build task to not depend on the test task
tasks.named("build") {
    dependsOn("assemble")
    finalizedBy("test")
}
