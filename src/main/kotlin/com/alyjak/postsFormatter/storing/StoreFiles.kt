package com.alyjak.postsFormatter.storing

import com.alyjak.postsFormatter.ERROR_FILES_CREATION_MESSAGE
import com.alyjak.postsFormatter.FILE_EXTENSION
import com.alyjak.postsFormatter.PATH_OUTPUT
import com.alyjak.postsFormatter.SUCCESS_CREATION_MESSAGE
import com.alyjak.postsFormatter.domain.Post
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.File
import java.nio.file.Files

fun storePosts(posts: List<Post>, mapper: ObjectMapper) {
    try {
        createFilesDir()
        posts.forEach { post ->
            createSingleFile(post, mapper)
        }
        println(SUCCESS_CREATION_MESSAGE)
    } catch (e: Exception) {
        println(ERROR_FILES_CREATION_MESSAGE)
    }
}

private fun createFilesDir() {
    Files.createDirectories(PATH_OUTPUT)
}

private fun createSingleFile(post: Post, mapper: ObjectMapper) {
    val fileName = "$PATH_OUTPUT/${post.id}$FILE_EXTENSION"
    val file = File(fileName)
    // create a new file
    file.writeText(mapper.writeValueAsString(post))
}
