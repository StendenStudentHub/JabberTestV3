plugins {
    id("java")
    id("org.sonarqube") version "4.4.1.3373"
    id "jacoco"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

sonar {
    properties {
        property("sonar.projectKey", "StendenStudentHub_JabberTestV3")
        property("sonar.organization", "stendenstudenthub")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

jacocoTestReport {
    reports {
        xml.required = true
    }
}