package com.justai.jaicf.template.scenario

import com.github.kotlintelegrambot.entities.KeyboardReplyMarkup
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.entities.keyboard.KeyboardButton
import com.justai.jaicf.activator.caila.caila
import com.justai.jaicf.builder.Scenario
import com.justai.jaicf.channel.telegram.telegram

val mainScenario = Scenario {
    state("start") {
        activators {
            regex("/start")
        }
        action {
            reactions.telegram?.say(
            "Привет!\n\nЭтот бот создан для оценки качества твоих знаний языка Kotlin." +
                    " Проверка будет состоять из двадцати тестовых вопросов.\n\nГотов начать?",
                replyMarkup = KeyboardReplyMarkup(listOf(listOf(KeyboardButton("Начать тест"))))
            )
        }
    }

    state("q1") {
        activators {
            regex("Начать тест")
        }
        action {
            reactions.telegram?.say(
                "Вопрос 1.\n\nЧто из этого в настоящее время не поддерживается в Kotlin?\n\n" +
                        "1) JVM\n" +
                        "2) JavaScript\n" +
                        "3) LLVM\n" +
                        "4) .NET CLR",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("JVM")),
                    listOf(KeyboardButton("JavaScript")),
                    listOf(KeyboardButton("LLVM")),
                    listOf(KeyboardButton(".NET CLR"))))
            )

        }
    }
    state("q2") {
        activators {
            regex("JVM")
            regex("JavaScript")
            regex("LLVM")
            regex(".NET CLR")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 2.\n\nКакое выражение Kotlin эквивалентно данному из Java:\n\n ```int x = a ? b : c```\n\n" +
                        "1) ```val x = a ?: b, c```\n\n" +
                        "2) ```val x = a ?: b, c```\n\n" +
                        "3) ```val x = a ? b : c```\n\n" +
                        "4) ```val x = if (a) b else c```\n\n",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("1"),
                        KeyboardButton("2"),
                        KeyboardButton("3"),
                        KeyboardButton("4"))
                ))
            )
        }
    }
    state("q3") {
        activators {
            regex("1")
            regex("2")
            regex("3")
            regex("4")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 3.\n\nЧто применимо для следующего объявления класса?\n" +
                        "```class Person (val name: String)```\n\n" +
                        "1) Он package-private\n" +
                        "2) Он может быть расширен другими классами\n" +
                        "3) Он public\n" +
                        "4) У него приватное свойство \"name\"",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Он package-private")),
                    listOf(KeyboardButton("Он может быть расширен другими классами")),
                    listOf(KeyboardButton("Он public")),
                    listOf(KeyboardButton("У него приватное свойство \"name\""))))
            )
        }
    }
    state("q4") {
        activators {
            regex("Он package-private")
            regex("Он может быть расширен другими классами")
            regex("Он public")
            regex("У него приватное свойство \"name\"")
        }
        action {
            reactions.telegram?.say(
                "Вопрос 4.\n\nЕсть ли у Kotlin примитивные типы данных, такие как int, long, float?\n\n" +
                        "1) Нет, Kotlin не имеет и не использует примитивные типы данных\n" +
                        "2) Нет, не на уровне языка. Но компилятор Kotlin использует примитивы JVM\n" +
                        "3) Да, но Kotlin всегда конвертирует их в не примитивные аналоги\n" +
                        "4) Да, Kotlin в этом отношении похож на Java",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Нет, Kotlin не имеет и не использует примитивные типы данных")),
                    listOf(KeyboardButton("Нет, не на уровне языка. Но компилятор Kotlin использует примитивы JVM")),
                    listOf(KeyboardButton("Да, но Kotlin всегда конвертирует их в не примитивные аналоги")),
                    listOf(KeyboardButton("Да, Kotlin в этом отношении похож на Java"))))
            )
        }
    }
    state("q5") {
        activators {
            regex("Нет, Kotlin не имеет и не использует примитивные типы данных")
            regex("Нет, не на уровне языка. Но компилятор Kotlin использует примитивы JVM")
            regex("Да, но Kotlin всегда конвертирует их в не примитивные аналоги")
            regex("Да, Kotlin в этом отношении похож на Java")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 5.\n\nЧто такое ```to``` в приведенном ниже примере:\n\n```val test = 33 to 42```\n\n" +
                        "1) Инфиксная функция, создающая пару (33, 42)\n" +
                        "2) Ключевое слово Kotlin для создания пары (33, 42)\n" +
                        "3) Ключевое слово для создания диапазона от 33 до 42\n" +
                        "4) Опечатка",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Инфиксная функция, создающая пару")),
                    listOf(KeyboardButton("Ключевое слово Kotlin для создания пары")),
                    listOf(KeyboardButton("Ключевое слово для создания диапазона")),
                    listOf(KeyboardButton("Опечатка"))))
            )
        }
    }
    state("q6") {
        activators {
            regex("Инфиксная функция, создающая пару")
            regex("Ключевое слово Kotlin для создания пары")
            regex("Ключевое слово для создания диапазона")
            regex("Опечатка")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 6.\n\nКакое из объявлений функций является валидным?\n\n" +
                        "1) ```int sum(int a, int b)```\n\n" +
                        "2) ```int sum(a: Int, b: Int)```\n\n" +
                        "3) ```function sum(a: Int, b: Int): Int```\n\n" +
                        "4) ```fun sum(a: Int, b: Int): Int```",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("int sum(int a, int b)")),
                    listOf(KeyboardButton("int sum(a: Int, b: Int)")),
                    listOf(KeyboardButton("function sum(a: Int, b: Int): Int")),
                    listOf(KeyboardButton("fun sum(a: Int, b: Int): Int"))))
            )
        }
    }
    state("q7") {
        activators {
            regex("int sum\\(int a, int b\\)")
            regex("int sum\\(a: Int, b: Int\\)")
            regex("function sum\\(a: Int, b: Int\\): Int")
            regex("fun sum\\(a: Int, b: Int\\): Int")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 7.\n\nВ чем ключевое отличие ```Iterable<T>``` и ```Sequence<T>```в Kotlin?\n\n" +
                        "1) Iterable<T> работает только с immutable коллекциями, Sequence<T> применим к mutable\n" +
                        "2) Нет никакой разницы, т.к. Sequence<T> это аналог Iterable<T>\n" +
                        "3) Последовательности обрабатываются лениво, итераторы жадно\n" +
                        "4) Последовательности обрабатываются по очереди, итераторы параллельно (многопоточно)",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Iterable<T> – только для immutable коллекций")),
                    listOf(KeyboardButton("Нет никакой разницы")),
                    listOf(KeyboardButton("Последовательности обрабатываются лениво, итераторы жадно")),
                    listOf(KeyboardButton("Итераторы обрабатываются параллельно (многопоточно)"))))
            )
        }
    }
    state("q8") {
        activators {
            regex("Iterable<T> – только для immutable коллекций")
            regex("Нет никакой разницы")
            regex("Последовательности обрабатываются лениво, итераторы жадно")
            regex("Итераторы обрабатываются параллельно \\(многопоточно\\)")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 8.\n\nЧего не предлагает dataclass?\n\n" +
                        "1) Авто-генерируемый метод toString()\n" +
                        "2) Метод copy(), для создания копии экземпляров\n" +
                        "3) Автоматическое преобразование из/в JSON\n" +
                        "4) Авто-генерируемые методы hashCode() и equals()",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Авто-генерируемый метод toString()")),
                    listOf(KeyboardButton("Метод copy(), для создания копии экземпляров.")),
                    listOf(KeyboardButton("Автоматическое преобразование из/в JSON")),
                    listOf(KeyboardButton("Авто-генерируемые методы hashCode() и equals()"))
                ))
            )
        }
    }
    state("q9") {
        activators {
            regex("Авто-генерируемый метод toString\\(\\)")
            regex("Метод copy\\(\\), для создания копии экземпляров.")
            regex("Автоматическое преобразование из/в JSON")
            regex("Авто-генерируемые методы hashCode\\(\\) и equals\\(\\)")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 9.\n\nЧто выведет следующий код?\n\n" +
                        "```" +
                        "val listA = mutableListOf(1, 2, 3)\n" +
                        "val listB = listA.add(4)\n" +
                        "print(listB)```\n\n" +
                        "1) [1, 2, 3, 4]\n" +
                        "2) True\n" +
                        "3) Ничего, тут ошибка компиляции\n" +
                        "4) Unit",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("\"[1, 2, 3, 4]\"")),
                    listOf(KeyboardButton("True")),
                    listOf(KeyboardButton("Ничего, тут ошибка компиляции")),
                    listOf(KeyboardButton("Unit"))))
            )
        }
    }
    state("q10") {
        activators {
            regex("\"\\[1, 2, 3, 4\\]\"")
            regex("True")
            regex("Ничего, тут ошибка компиляции")
            regex("Unit")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 10.\n\nВ чем разница между a и b?\n\n" +
                        "```" +
                        "var a: String? = \"KotlinQuiz\"\n" +
                        "var b: String = \"KotlinQuiz\"```" +
                        "1) a является volatile, как в Java\n" +
                        "2) b является final и не может быть изменено\n" +
                        "3) a является final и не может быть изменено\n" +
                        "4) b никогда не сможет стать null",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("a является volatile, как в Java")),
                    listOf(KeyboardButton("b является final и не может быть изменено")),
                    listOf(KeyboardButton("a является final и не может быть изменено")),
                    listOf(KeyboardButton("b никогда не сможет стать null"))))
            )
        }
    }
    state("q11") {
        activators {
            regex("a является volatile, как в Java")
            regex("b является final и не может быть изменено")
            regex("a является final и не может быть изменено")
            regex("b никогда не сможет стать null")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 11.\n\nКак в Kotlin правильно объявить переменную целочисленного типа?\n\n" +
                        "1) ```var i : int = 42```\n\n" +
                        "2) ```let i = 42```\n\n" +
                        "3) ```int i = 42```\n\n" +
                        "4) ```var i : Int = 42```",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("var i : int = 42")),
                    listOf(KeyboardButton("let i = 42")),
                    listOf(KeyboardButton("int i = 42")),
                    listOf(KeyboardButton("var i : Int = 42"))))
            )
        }
    }
    state("q12") {
        activators {
            regex("var i : int = 42")
            regex("let i = 42")
            regex("int i = 42")
            regex("var i : Int = 42")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 12.\n\nКакой тип у arr?\n\n" +
                        "```val arr = arrayOf(1, 2, 3)\n\n```" +
                        "1) ```Array<Int>```\n\n" +
                        "2) ```Int[]```\n\n" +
                        "3) ```int[]```\n\n" +
                        "4) ```IntArray```",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Array<Int>")),
                    listOf(KeyboardButton("Int[]")),
                    listOf(KeyboardButton("int[]")),
                    listOf(KeyboardButton("IntArray"))))
            )
        }
    }
    state("q13") {
        activators {
            regex("Array<Int>")
            regex("Int\\[\\]")
            regex("int\\[\\]")
            regex("IntArray")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 13.\n\nЧто из приведенного в Kotlin, эквивалентно статическому методу из Java?\n\n" +
                        "1) ```class Foo {\n" +
                        "  @static fun bar() : String = \"Kotlin\"\n" +
                        "}```\n\n" +
                        "2) ```class Foo {\n" +
                        "  companion object {\n" +
                        "     fun bar() : String = \"Kotlin\"\n" +
                        "  }\n" +
                        "}```\n\n" +
                        "3) ```class Foo {\n" +
                        "  static fun bar() : String = \"Kotlin\"\n" +
                        "}```",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Класс с использованием @static")),
                    listOf(KeyboardButton("Класс с использованием companion object")),
                    listOf(KeyboardButton("Класс с использованием static"))
                ))
            )
        }
    }
    state("q14") {
        activators {
            regex("Класс с использованием @static")
            regex("Класс с использованием companion object")
            regex("Класс с использованием static")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 14.\n\nДля чего нужен оператор !! ?\n\n" +
                        "1) Он возвращает левый операнд, если тот не равен null, иначе возвращает правый операнд\n" +
                        "2) Это оператор модуля, аналог % в Java\n" +
                        "3) Он сравнивает два значения на тождественность\n" +
                        "4) Он преобразует любое значение в ненулевой тип и выбрасывает исключение, если значение равно null",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Возвращает левый операнд, если тот не null, иначе – возвращает правый")),
                    listOf(KeyboardButton("Он Аналогичен % в Java")),
                    listOf(KeyboardButton("Сравнивает два значения на тождественность")),
                    listOf(KeyboardButton("Кидает исключение, если операнд равен null"))))
            )
        }
    }
    state("q15") {
        activators {
            regex("Возвращает левый операнд, если тот не null, иначе – возвращает правый")
            regex("Он Аналогичен % в Java")
            regex("Сравнивает два значения на тождественность")
            regex("Кидает исключение, если операнд равен null")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 15.\n\nУкажите правильный синтаксис для преобразования строки “42” в long:\n\n" +
                        "1) ```val l: Long = <Long>\"42\"```\n\n" +
                        "2) ```val l: Long = \"42\".toLong()```\n\n" +
                        "3) ```val l: Long = (Long)\"42\"```\n\n" +
                        "4) ```val l: Long = Long.parseLong(\"42\")```",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("val l: Long = <Long>\"42\"")),
                    listOf(KeyboardButton("val l: Long = \"42\".toLong()")),
                    listOf(KeyboardButton("val l: Long = (Long)\"42\"")),
                    listOf(KeyboardButton("val l: Long = Long.parseLong(\"42\")"))))
            )
        }
    }
    state("q16") {
        activators {
            regex("val l: Long = <Long>\"42\"")
            regex("val l: Long = \"42\".toLong\\(\\)")
            regex("val l: Long = \\(Long\\)\"42\"")
            regex("val l: Long = Long.parseLong\\(\"42\"\\)")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 16.\n\nЧто такое корутины (coroutines)?\n\n" +
                        "1) Функции, которые принимают другие функции в качестве аргументов или возвращают их\n" +
                        "2) Иснтрумент, обеспечивающий асинхронное выполнение без блокировки потока\n" +
                        "3) Термин Kotlin, используемый в методах класса\n" +
                        "4) Автоматически сгенерированные методы hashCode() и equals() в data classes",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Функции, принимающие/возвращающие функции")),
                    listOf(KeyboardButton("Инструмент асинхронной работы кода")),
                    listOf(KeyboardButton("Термин для описания методов")),
                    listOf(KeyboardButton("Генерация бойлерплейта"))))
            )
        }
    }
    state("q17") {
        activators {
            regex("Функции, принимающие/возвращающие функции")
            regex("Инструмент асинхронной работы кода")
            regex("Термин для описания методов")
            regex("Генерация бойлерплейта")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 17.\n\nЧто делает этот код: \n\n" +
                        "```foo()()```\n\n" +
                        "1) Создает двумерный массив\n" +
                        "2) Не скомпилируется\n" +
                        "3) Вызывает асинхронно foo\n" +
                        "4) Вызывает функцию, которая вернется после вызова foo",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Создает двумерный массив")),
                    listOf(KeyboardButton("Не скомпилируется")),
                    listOf(KeyboardButton("Вызывает асинхронно foo")),
                    listOf(KeyboardButton("Вызывает функцию, которая вернется после вызова foo"))
                ))
            )
        }
    }
    state("q18") {
        activators {
            regex("Создает двумерный массив")
            regex("Не скомпилируется")
            regex("Вызывает асинхронно foo")
            regex("Вызывает функцию, которая вернется после вызова foo")
        }
        action {
            reactions.telegram?.say(
                "Вопрос 18.\n\nСовместим ли Kotlin с Java?\n\n" +
                        "1) Kotlin может легко вызвать код Java, в то время как Java не может получить доступ к коду на Kotlin\n" +
                        "2) Kotlin предоставляет уровень совместимости для взаимодействия с Java, который становится доступен в рантайме\n" +
                        "3) Пока Kotlin запущен в JVM, он не может взаимодействовать с Java\n" +
                        "4) Kotlin может легко вызвать Java код и наоборот",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Kotlin совместим с Java, но не наоборот")),
                    listOf(KeyboardButton("Kotlin совместим с Java, но только в рантайме")),
                    listOf(KeyboardButton("Kotlin совместим с Java, но только не в рантайме")),
                    listOf(KeyboardButton("Полная совместимость в обоих направлениях"))))
            )
        }
    }
    state("q19") {
        activators {
            regex("Kotlin совместим с Java, но не наоборот")
            regex("Kotlin совместим с Java, но только в рантайме")
            regex("Kotlin совместим с Java, но только не в рантайме")
            regex("Полная совместимость в обоих направлениях")
        }
        action {
            reactions.telegram?.say(
                "Вопрос 19.\n\nВ чем разница между val и var в Kotlin?\n\n" +
                        "1) Переменные, объявленные с помощью val, являются final, а переменные var – нет\n" +
                        "2) Переменные, объявленные с помощью val, имеют доступ только к const членам\n" +
                        "3) Переменные, объявленные с помощью var, являются final, а переменные val – нет\n" +
                        "4) 4",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("val – final, var – нет")),
                    listOf(KeyboardButton("val имеет доступ только к константам")),
                    listOf(KeyboardButton("var – final, val – нет")),
                    listOf(KeyboardButton("разные области видимости"))))
            )
        }
    }
    state("q20") {
        activators {
            regex("val – final, var – нет")
            regex("val имеет доступ только к константам")
            regex("var – final, val – нет")
            regex("разные области видимости")
        }
        action {
            reactions.telegram?.say(
                parseMode = ParseMode.MARKDOWN,
                text = "Вопрос 20.\n\nЧто выведет следующий код: \n\n" +
                        "```val list : List<Int> = listOf(1, 2, 3)\n" +
                        "\tlist.add(4)\n" +
                        "\tprint(list)```\n\n" +
                        "1) Он не компилируется, так как List не имеет метода add\n" +
                        "2) [1, 2, 3, 4]\n" +
                        "3) [5, 6, 7]\n" +
                        "4)Он не компилируется, из-за listOf",
                replyMarkup = KeyboardReplyMarkup(listOf(
                    listOf(KeyboardButton("Он не компилируется, так как List – immutable")),
                    listOf(KeyboardButton("[1, 2, 3, 4]")),
                    listOf(KeyboardButton("[5, 6, 7]")),
                    listOf(KeyboardButton("Он не компилируется, из-за вызова listOf"))))
            )
        }
    }

    state("finish") {
        activators {
            regex("Он не компилируется, так как List – immutable")
            regex("\\[1, 2, 3, 4\\]")
            regex("Он не компилируется, из-за listOf")
            regex("\\[5, 6, 7\\]")
        }
        action {

            reactions.telegram?.say("Тест окончен")
        }
    }

    fallback {
        reactions.sayRandom(
            "Я тебя не понимаю, попробуй нажимать на кнопки!",
            "Я довольно глупый бот, поэтому нажимай на кнпоки, пожалуйста!"
        )
    }
}