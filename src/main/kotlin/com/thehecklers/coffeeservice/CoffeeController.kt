package com.thehecklers.coffeeservice

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/coffees")
class CoffeeController(private val service: CoffeeService) {
    @GetMapping
    fun all(): Flux<Coffee> {
        return service.getAllCoffees()
    }

    @GetMapping("/{id}")
    fun byId(@PathVariable id: String): Mono<Coffee> {
        return service.getCoffeeById(id)
    }

    @GetMapping(value = "/{id}/orders", produces = arrayOf(MediaType.TEXT_EVENT_STREAM_VALUE))
    fun orders(@PathVariable id: String): Flux<CoffeeOrder> {
        return service.getOrders(id)
    }
}