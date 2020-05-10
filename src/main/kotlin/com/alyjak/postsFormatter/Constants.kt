package com.alyjak.postsFormatter

import java.nio.file.Path
import java.nio.file.Paths

const val BASE_URL = "https://jsonplaceholder.typicode.com"
const val POST_PATH = "$BASE_URL/posts"
const val FILE_EXTENSION = ".json"
val PATH_OUTPUT: Path = Paths.get("data")

const val GET_REQUEST = "GET"
const val SUCCESS_MESSAGE = "Success"
const val SUCCESS_CREATION_MESSAGE = "Files created successful"
const val ERROR_WRONG_URL_MESSAGE = "Wrong JSONPlaceholder url"
const val ERROR_CONNECTION_MESSAGE = "Internet connection error"
const val ERROR_INCORRECT_RESPONSE_MESSAGE = "Incorrect response error"
const val ERROR_FILES_CREATION_MESSAGE = "Error in files creation"
const val EMPTY_RESPONSE_MESSAGE = "Empty response!"

const val HELLO_MESSAGE = "Hello! This project will transform and store posts downloaded from JSONPlaceholder. Let's start..."
const val BYE_MESSAGE = "Bye!"
