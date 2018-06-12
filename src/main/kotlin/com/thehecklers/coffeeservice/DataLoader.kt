package com.thehecklers.coffeeservice

import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.util.*
import javax.annotation.PostConstruct

@Component
class DataLoader(private val repo: CoffeeRepository) {
    @PostConstruct
    private fun load() {
        repo.deleteAll().thenMany(
                Flux.just("Kaldi's Coffee", "Espresso Roast", "Blue Bottle", "Philz Coffee", "Tim Hortons", "Peet's",
                        "Pike Place", "Café Bustelo", "Death Wish", "Green Mountain")
                        .map { name -> Coffee(UUID.randomUUID().toString(), name) }
                        .flatMap<Coffee> { repo.save(it) })
                .thenMany(repo.findAll())
                .subscribe { println(it) }
    }

}