package com.alyjak.postsFormatter.storing

import com.alyjak.postsFormatter.domain.Post
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.File

class StoreFilesKtTest {

    private val mapper: ObjectMapper = jacksonObjectMapper()

    private val createdDir = File("data")
    private val file1 = File("data/1.json")
    private val file2 = File("data/2.json")
    private val file3 = File("data/3.json")
    private val post1 = Post(1, 1, "test", "1 test test")
    private val post2 = Post(2, 2, "test2", "2 test test")
    private val post3 = Post(66, 3, "test3", "3 test test")
    private val json1 = "{\"userId\":1,\"id\":1,\"title\":\"test\",\"body\":\"1 test test\"}"
    private val json2 = "{\"userId\":2,\"id\":2,\"title\":\"test2\",\"body\":\"2 test test\"}"
    private val json3 = "{\"userId\":66,\"id\":3,\"title\":\"test3\",\"body\":\"3 test test\"}"

    @BeforeEach
    fun setUp() {
        if (file1.exists()) {
            file1.delete()
        }
        if (file2.exists()) {
            file2.delete()
        }
        if (file3.exists()) {
            file3.delete()
        }
        if (createdDir.exists()) {
            createdDir.delete()
        }
    }

    @Test
    fun storePosts_emptyList_onlyDirCreated_success() {
        // Arrange
        val files: List<Post> = ArrayList()
        // Act
        storePosts(files, mapper)
        // Assert
        assertTrue(createdDir.exists())
        assertTrue(createdDir.isDirectory)
    }

    @Test
    fun storePosts_onePostInList_success() {
        // Arrange
        val files: List<Post> = listOf(post1)
        // Act
        storePosts(files, mapper)
        // Assert
        assertTrue(createdDir.exists())
        assertTrue(createdDir.isDirectory)
        assertTrue(file1.exists())
        val content = file1.readText()
        assertTrue(content.isNotEmpty())
        assertTrue(content.contains(json1))
    }

    @Test
    fun storePosts_moreThanOnePostInList_success() {
        // Arrange
        val files: List<Post> = listOf(post1, post2, post3)
        // Act
        storePosts(files, mapper)
        // Assert
        assertTrue(createdDir.exists())
        assertTrue(createdDir.isDirectory)
        assertTrue(file1.exists())

        var content = file1.readText()
        assertTrue(content.isNotEmpty())
        assertTrue(content.contains(json1))

        assertTrue(file2.exists())
        content = file2.readText()
        assertTrue(content.isNotEmpty())
        assertTrue(content.contains(json2))

        assertTrue(file3.exists())
        content = file3.readText()
        assertTrue(content.isNotEmpty())
        assertTrue(content.contains(json3))
    }

}