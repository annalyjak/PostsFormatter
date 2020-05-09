package com.alyjak.postsFormatter.controller

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.io.File

@WebMvcTest
internal class PostsControllerTest(@Autowired val mockMvc: MockMvc) {

    private val createdDir = File("data")
    private val file1 = File("data/1.json")
    private val json1 = "{\"userId\":1,\"id\":1,\"title\":\"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\"body\":\"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"}"

    @BeforeEach
    fun setUp() {
        if (file1.exists()) {
            file1.delete()
        }
        if (createdDir.exists()) {
            createdDir.delete()
        }
    }

    @Test
    fun runProgram() {
        // Act
        mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk)
        // Assert
        assertTrue(createdDir.exists())
        assertTrue(createdDir.isDirectory)
        assertTrue(file1.exists())

        val content = file1.readText()
        assertTrue(content.isNotEmpty())
        assertTrue(content.contains(json1))
    }
}