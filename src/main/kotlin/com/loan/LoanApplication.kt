package com.loan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class LoanApplication

fun main(args: Array<String>) {
	runApplication<LoanApplication>(*args)
}
