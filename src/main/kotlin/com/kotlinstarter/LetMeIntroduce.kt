package com.kotlinstarter


class LetMeIntroduce {
    fun main(args: Array<String>) {
        val me = Identity(
            name = "Heesun Choi",
            strengths = setOf("Positive", "Concentration", "Self development")
        )
        me.selfIntroduce()
    }
}
