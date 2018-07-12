object VersionInfo {
    const val camel: String = "2.22.0"
    const val slf4j = "1.7.13"
    const val log4j2 = "2.4.1"
    const val weld = "2.3.1.Final"
    const val deltaspike = "1.5.1"
    const val springBoot = "2.0.3.RELEASE"
    const val springVersion = "4.3.17.RELEASE"
    const val vertx = "3.5.2"
    val javaSource = JavaVersion.VERSION_1_8
}


val versions: VersionInfo by extra { VersionInfo }
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.3.RELEASE")
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.2")
    }
}

apply {
    //	plugin("java")
//	plugin("eclipse")
//	plugin("idea")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
    plugin("org.junit.platform.gradle.plugin")
}

plugins {
    `java-library`
    idea
    eclipse
}

group = "io.truthencode.spring"
version = "0.0.1-SNAPSHOT"


//tasks.withType<JavaPluginConvention> {
//	sourceCompatibility = JavaVersion.VERSION_1_8
//	targetCompatibility = JavaVersion.VERSION_1_8
//}
/**
 * Configure java compiler options.
 */
java {
    sourceCompatibility = versions.javaSource
    targetCompatibility = versions.javaSource
}

repositories {
    mavenCentral()
}


//	test {
//		useJUnitPlatform()
//	}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-jersey")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.apache.camel:camel-spring-boot-starter:2.22.0")
    implementation("org.apache.camel:camel-vertx:${versions.camel}")
    implementation(group = "ch.qos.logback", name = "logback-classic", version = "1.2.3")

    implementation(group = "io.vertx", name = "vertx-core", version = "3.5.2")

    implementation(group = "io.vertx", name = "vertx-web", version = "3.5.2")

    annotationProcessor("org.projectlombok:lombok")
    testCompile("org.springframework.boot:spring-boot-starter-test")
    testCompile("org.junit.jupiter:junit-jupiter-api")

    testRuntime("org.junit.jupiter:junit-jupiter-engine")

    testRuntime("org.junit.vintage:junit-vintage-engine:4.12.2")
}

