grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
		mavenRepo "http://maven.springframework.org/snapshot"
		mavenCentral()
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

      def excludes = {
        excludes "slf4j-simple", "persistence-api", "commons-logging", "jcl-over-slf4j", "slf4j-api", "jta"
        excludes "spring-core", "spring-beans", "spring-aop", "spring-tx", "spring-context", "spring-web"
      }
      compile("org.grails:grails-datastore-gorm-redis:1.0.0.BUILD-SNAPSHOT", excludes)
      compile( "org.springframework:spring-datastore-web:1.0.0.BUILD-SNAPSHOT", excludes)
      test("org.grails:grails-datastore-gorm-test:1.0.0.BUILD-SNAPSHOT", excludes)

    }
}
