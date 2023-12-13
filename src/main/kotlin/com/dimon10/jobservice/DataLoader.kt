package com.dimon10.jobservice

import com.dimon10.jobservice.entity.SkillEntity
import com.dimon10.jobservice.repository.SkillRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class DataLoader @Autowired constructor(private val skillRepository: SkillRepository) : ApplicationRunner {

    override fun run(args: ApplicationArguments) {
        skillRepository.saveAll(
            listOf(
                // Programming Languages
                SkillEntity("C#", "C#"),
                SkillEntity("Golang", "Go"),
                SkillEntity("Java", "Java"),
                SkillEntity("JavaScript", "JS"),
                SkillEntity("Kotlin", "Kotlin"),
                SkillEntity("PHP", "PHP"),
                SkillEntity("Python", "Python"),
                SkillEntity("Ruby", "Ruby"),
                SkillEntity("Rust", "Rust"),
                SkillEntity("Scala", "Scala"),
                SkillEntity("Swift", "Swift"),
                SkillEntity("TypeScript", "TS"),
                // Frameworks
                SkillEntity("Angular", "Angular"),
                SkillEntity("Django", "Django"),
                SkillEntity("Express.js", "Express.js"),
                SkillEntity( "Flutter", "Flutter"),
                SkillEntity( "Laravel", "Laravel"),
                SkillEntity("Ruby on Rails", "Rails"),
                SkillEntity("React", "React"),
                SkillEntity("Spring framework", "Spring"),
                SkillEntity("Vue.js", "Vue.js"),
                // Databases
                SkillEntity("MongoDB", "MongoDB"),
                SkillEntity("MySQL", "MySQL"),
                SkillEntity("PostgreSQL", "PostgreSQL"),
                SkillEntity("Redis", "Redis"),
                // Message Brokers
                SkillEntity("ActiveMQ", "ActiveMQ"),
                SkillEntity("Kafka", "Kafka"),
                SkillEntity("MQTT", "MQTT"),
                SkillEntity("RabbitMQ", "RabbitMQ"),
                // Test Frameworks
                SkillEntity("Appium", "Appium"),
                SkillEntity("Cucumber", "Cucumber"),
                SkillEntity("Cypress", "Cypress"),
                SkillEntity("Jest", "Jest"),
                SkillEntity("JUnit", "JUnit"),
                SkillEntity("Mocha", "Mocha"),
                SkillEntity("Playwright", "Playwright"),
                SkillEntity("Robot Framework", "Robot Framework"),
                SkillEntity("TestNG", "TestNG"),
                // Libraries
                SkillEntity("Retrofit", "Retrofit"),
                SkillEntity("OkHttp", "OkHttp"),
                SkillEntity("Gson", "Gson"),
                SkillEntity("Jackson", "Jackson"),
                SkillEntity("Request", "Request"),
                SkillEntity("Axios", "Axios"),
                SkillEntity("Lombok", "Lombok"),
                SkillEntity("Guava", "Guava"),
                SkillEntity("SLF4J", "SLF4J"),
                SkillEntity("Log4j", "Log4j"),
                // Additional
                SkillEntity("Docker", "Docker"),
                SkillEntity("Kubernetes", "Kubernetes"),
                SkillEntity("Elasticsearch", "Elasticsearch"),
                SkillEntity("Logstash", "Logstash"),
                SkillEntity("Kibana", "Kibana")
            )
        )
    }
}