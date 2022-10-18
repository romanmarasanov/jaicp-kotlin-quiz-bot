package com.justai.jaicf.template.dao

import java.util.concurrent.ConcurrentHashMap

class DAO {
    private val rightAnswers = mapOf(
        1 to ".NET CLR",
        2 to "4",
        3 to "Он public",
        4 to "Нет, не на уровне языка. Но компилятор Kotlin использует примитивы JVM",
        5 to "Инфиксная функция, создающая пару",
        6 to "fun sum(a: Int, b: Int): Int",
        7 to "Последовательности обрабатываются лениво, итераторы жадно",
        8 to "Автоматическое преобразование из/в JSON",
        9 to "True",
        10 to "b никогда не сможет стать null",
        11 to "var i : Int = 42",
        12 to "Array<Int>",
        13 to "Класс с использованием companion object",
        14 to "Кидает исключение, если операнд равен null",
        15 to "val l: Long = \"42\".toLong()",
        16 to "Инструмент асинхронной работы в Kotlin",
        17 to "Вызывает функцию, которая вернется после вызова foo",
        18 to "Полная совместимость в обоих направлениях",
        19 to "val – final, var – нет",
        20 to "Он не компилируется, так как List – immutable",
    )

    private val usersResults: ConcurrentHashMap<String, Int> = ConcurrentHashMap()

    fun writeResult(q: Int, ans: String, username: String) {
        if (rightAnswers[q].equals(ans)) {
            val prevNumber: Int = usersResults[username]!!
            usersResults[username] = prevNumber.plus(1)
        }
    }

    fun createOrResetRecord(username: String) {
        usersResults[username] = 0
    }

    fun getScores(username: String): Int? {
        return usersResults[username]
    }
}