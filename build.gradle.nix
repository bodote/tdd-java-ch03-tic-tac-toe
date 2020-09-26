plugins {
  id 'java'
  id 'jacoco'
  id 'info.solidsoft.pitest' version '1.5.1'
}

sourceCompatibility = 11
version = '1.0'

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    testCompile group: 'junit', name: 'junit', version: '4.13'
    implementation 'org.junit.jupiter:junit-jupiter:5.4.2'
    dependencies { testCompile "org.mockito:mockito-core:2.+" }
}
test {
  useJUnitPlatform()
  finalizedBy jacocoTestReport
}

jacocoTestReport {
  dependsOn test   
}
 
pitest {
  junit5PluginVersion = '0.12'
  timestampedReports = false    
}