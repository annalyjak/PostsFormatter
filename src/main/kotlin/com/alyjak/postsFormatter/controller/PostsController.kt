package com.alyjak.postsFormatter.controller

import com.alyjak.postsFormatter.*
import com.alyjak.postsFormatter.exceptions.ConnectionError
import com.alyjak.postsFormatter.utils.parsing.formatPosts
import com.alyjak.postsFormatter.utils.storing.storePosts
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.io.BufferedReader
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

@RestController
class PostsController(val mapper: ObjectMapper) {

    @GetMapping("/")
    fun index(): ResponseEntity<*> {
        println(HELLO_MESSAGE)
        val messageToReturn = try {
            downloadAndSavePosts()
            SUCCESS_MESSAGE
        } catch (e: MalformedURLException) {
            ERROR_WRONG_URL_MESSAGE
        } catch (e: IOException) {
            ERROR_CONNECTION_MESSAGE
        } catch (e: ConnectionError) {
            ERROR_INCORRECT_RESPONSE_MESSAGE
        }
        println(messageToReturn)
        println(BYE_MESSAGE)
        return if (messageToReturn == SUCCESS_MESSAGE) {
            ResponseEntity.ok(messageToReturn)
        } else {
            ResponseEntity(messageToReturn, HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }

    @Throws(ConnectionError::class, IOException::class, MalformedURLException::class)
    fun downloadAndSavePosts() {
        val url = URL(POST_PATH)
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = GET_REQUEST
            println("URL : $url")
            println("Response Code : $responseCode")

            if (responseCode == 200) {
                val response: String = inputStream.bufferedReader().use(BufferedReader::readText)
                val posts = formatPosts(response, mapper)
                storePosts(posts, mapper)
            } else {
                throw ConnectionError()
            }
        }
    }

}