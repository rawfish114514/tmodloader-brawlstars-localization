plugins {
    kotlin("jvm") version "2.0.21"
}

group = "rawfish"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.hjson:hjson:3.1.0")
    implementation("com.jsoizo:kotlin-csv-jvm:1.10.0")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}