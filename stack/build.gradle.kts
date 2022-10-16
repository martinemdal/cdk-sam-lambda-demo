plugins {
    kotlin("jvm") version "1.7.20"
    id("application")
}

application {
    mainClass.set("stack.StackKt")
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

dependencies {
// https://mvnrepository.com/artifact/software.amazon.awscdk/aws-cdk-lib
    implementation("software.amazon.awscdk:aws-cdk-lib:2.46.0")
    testImplementation(kotlin("test"))
}

tasks {
    test {
        useTestNG()
    }
}
