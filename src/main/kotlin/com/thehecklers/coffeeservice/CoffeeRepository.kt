package com.thehecklers.coffeeservice

import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CoffeeRepository: ReactiveCrudRepository<Coffee, String>