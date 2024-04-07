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