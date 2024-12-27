package com.lcaohoanq.etrade

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class KotlinEtradeApplication

fun main(args: Array<String>) {
    runApplication<KotlinEtradeApplication>(*args)
}
