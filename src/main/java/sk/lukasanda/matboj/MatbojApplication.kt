package sk.lukasanda.matboj

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class MatbojApplication

fun main(args: Array<String>) {
    runApplication<MatbojApplication>(*args)
}
