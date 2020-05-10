package com.alyjak.postsFormatter.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = [JacksonConfiguration::class], loader = AnnotationConfigContextLoader::class)
internal class JacksonConfigurationTest(@Autowired val objectMapper: ObjectMapper) {

    @Test
    fun textJacksonObjectMapper() {
        // Assert
        assertNotNull(objectMapper)
    }
}