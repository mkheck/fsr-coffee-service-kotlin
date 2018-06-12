package com.thehecklers.coffeeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoffeeServiceApplication

fun main(args: Array<String>) {
    runApplication<CoffeeServiceApplication>(*args)
}
