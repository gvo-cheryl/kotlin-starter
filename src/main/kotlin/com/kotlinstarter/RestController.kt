package com.kotlinstarter

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.lang.Integer.parseInt

@RestController
class RestController {

    @GetMapping("/")
    fun hello() {
        basic()
        // variable
        val sumInt = sum(3, 5)
        var sumInt2: Int = sum2(1, 2)
        sumInt2 += 1
        println("Sum: $sumInt")
        println("Sum2: $sumInt2")
        val rectangle = Rectangle(3, 5)
        println("Rectangle: ${rectangle.perimeter}")
        println("/?")

        // string
        var a = 1
        var s1 = "a is $a"
        a = 2
        var s2 = "${s1.replace("is", "was")}, now is $a"
        println(s2)
        println(maxOf(1, 10))

        // list
        val items = listOf("one", "two", "three", "four")
        for (item in items) {
            println(item)
        }
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }

        var index = 0
        while (index < items.size) {
            println("item at $index is ${items[index]}")
            index++
        }

        // when
        println(describe(1))
        println(describe("Hello"))
        println(describe(10L))
        println(describe(100))
        println(describe("String"))

        // ranges
        val x = 10
        val y = 9
        if (x in 1 .. y+1) {
            println("fits in range")
        }
        for (i in 1..10) {
            println(i)
        }
        for (i in 1..10 step 2) {
            println(i)
        }

        // lambda
        val fruits = listOf("apple", "avocado", "orange", "kiwi")
        fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.uppercase() }
            .forEach { println(it) }

        // nullable
        printProduct("5", "6")

        // infix
        infix fun Int.times(str: String) = str.repeat(this)
        println(2 times "Bye")

        // run
        getNullableLength(null)
        getNullableLength("")
        getNullableLength("some string with Kotlin")

        val result = "Kotlin".run {
            println(this)
            length
        }
    }

    fun basic() {
        println("Hello World")
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum2(a: Int, b: Int) = a + b

    open class Shape

    class Rectangle(val width: Int, val height: Int) {
        val perimeter = (width + height) * 2
    }

    fun maxOf(a: Int, b: Int) = if (a > b) a else b

    fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

    fun printProduct(arg1: String, arg2: String) {
        val x = parseInt(arg1)
        val y = parseInt(arg2)
        if (x != null && y != null) {
            println(x * y)
        } else {
            println("$arg1 or $arg2 is not a number")
        }
    }

    fun getNullableLength(ns: String?) {
        println("for \"$ns\":")
        ns?.run {                                                  // 1
            println("\tis empty? " + isEmpty())                    // 2
            println("\tlength = $length")
            length                                                 // 3
        }
    }
}