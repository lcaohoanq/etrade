package com.lcaohoanq.kotlinbasics

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.lcaohoanq.kotlinbasics.mapper"])
class KotlinbasicsApplication

fun main(args: Array<String>) {
    runApplication<KotlinbasicsApplication>(*args)
}
