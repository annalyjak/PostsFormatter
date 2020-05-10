package com.alyjak.postsFormatter.utils.parsing

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Assertions.assertEquals

import org.junit.jupiter.api.Test

internal class ParseStringToListKtTest {

    private val mapper: ObjectMapper = jacksonObjectMapper()

    @Test
    fun formatPosts_moreThanOne_success() {
        // Arrange
        val stringToFormat = "[\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n" +
                "    \"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 2,\n" +
                "    \"title\": \"qui est esse\",\n" +
                "    \"body\": \"est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 3,\n" +
                "    \"title\": \"ea molestias quasi exercitationem repellat qui ipsa sit aut\",\n" +
                "    \"body\": \"et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut\"\n" +
                "  }" +
                "]"
        // Act
        var result = formatPosts(stringToFormat, mapper)
        // Assert
        assertEquals(3, result.size)
    }

    @Test
    fun formatPosts_onlyOneInList_success() {
        // Arrange
        val stringToFormat = "[\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 3,\n" +
                "    \"title\": \"ea molestias quasi exercitationem repellat qui ipsa sit aut\",\n" +
                "    \"body\": \"et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut\"\n" +
                "  }" +
                "]"
        // Act
        var result = formatPosts(stringToFormat, mapper)
        // Assert
        assertEquals(1, result.size)
    }

    @Test
    fun formatPosts_emptyString_emptyListReturned_success() {
        // Arrange
        val stringToFormat = ""
        // Act
        var result = formatPosts(stringToFormat, mapper)
        // Assert
        assertEquals(0, result.size)
    }
}