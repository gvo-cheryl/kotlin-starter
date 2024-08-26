package com.kotlinstarter

import lombok.Data

@Data
class Identity(val name: String, val strengths: Set<String>) {

    fun selfIntroduce() {
        println("안녕하세요, 저는 $name 입니다.")
        println("제 강점은 다음과 같습니다:")
        strengths.forEach { println("- $it") }
    }
}


fun main() {
    val me = Identity(
        name = "Jiyeon Choi",
        strengths = setOf("Positive", "Concentration", "Self development")
    )
    me.selfIntroduce()
}


