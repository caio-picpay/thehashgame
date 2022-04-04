plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")

    compileOnly("org.projectlombok:lombok:1.18.22")
    annotationProcessor ("org.projectlombok:lombok:1.18.22")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.13.2")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
