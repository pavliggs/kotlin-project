package com.khovaylo.application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinProjectApplication

fun main(args: Array<String>) {
	runApplication<KotlinProjectApplication>(*args)
}
