package com.alyjak.postsFormatter.parsing

import com.alyjak.postsFormatter.EMPTY_RESPONSE_MESSAGE
import com.alyjak.postsFormatter.domain.Post
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.MismatchedInputException
import com.fasterxml.jackson.module.kotlin.readValue

fun formatPosts(response: String, mapper: ObjectMapper): List<Post> {
    val list: List<Post> = try {
        mapper.readValue(response)
    } catch (e: MismatchedInputException) {
        println(EMPTY_RESPONSE_MESSAGE)
        ArrayList()
    }
    println("Number of downloaded posts : ${list.size}")
    return list
}