package com.alyjak.postsFormatter

import com.alyjak.postsFormatter.controller.PostsController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsFormatterApplicationTests(@Autowired val controller: PostsController) {

	@Test
	fun contextLoads() {
		assertThat(controller).isNotNull
	}

}
