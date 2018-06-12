package com.thehecklers.coffeeservice

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration
import java.time.Instant

@Service
class CoffeeService(private val repo: CoffeeRepository) {
    fun getAllCoffees(): Flux<Coffee> {
        return repo.findAll()
    }

    fun getCoffeeById(id: String): Mono<Coffee> {
        return repo.findById(id)
    }

    fun getOrders(coffeeId: String): Flux<CoffeeOrder> {
        return Flux.generate<CoffeeOrder> { sink -> sink.next(CoffeeOrder(coffeeId, Instant.now())) }
                .delayElements(Duration.ofSeconds(1))
    }

}