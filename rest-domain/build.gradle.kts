plugins {
    id("java")
}

group = "xyz.moveuk"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
//    api("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    // JWT library
//    implementation("io.jsonwebtoken:jjwt-api:0.12.5")
//    implementation("io.jsonwebtoken:jjwt-impl:0.12.5")
//    implementation("io.jsonwebtoken:jjwt-jackson:0.12.5")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-redis
//    implementation("org.springframework.boot:spring-boot-starter-data-redis")

//    runtimeOnly("com.h2database:h2")
//    runtimeOnly("com.mysql:mysql-connector-j")
    runtimeOnly("org.postgresql:postgresql")


    // QueryDsl
//    implementation("com.querydsl:querydsl-jpa:5.1.0:jakarta")
//    annotationProcessor("com.querydsl:querydsl-apt:5.1.0:jakarta")
    //java.lang.NoClassDefFoundError 대응을 위해 추가
//    annotationProcessor("jakarta.annotation:jakarta.annotation-api")
//    annotationProcessor("jakarta.persistence:jakarta.persistence-api")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
    systemProperties["spring.profiles.active"] = "test"
}

//val querydslSrcDir = "src/main/generated"
//
//tasks.withType<JavaCompile> {
//    options.generatedSourceOutputDirectory.set(file(querydslSrcDir))
//}
//
//sourceSets {
//    getByName("main").java.srcDirs += file(querydslSrcDir)
//}
//
//tasks.clean {
//    delete(file(querydslSrcDir))
//}