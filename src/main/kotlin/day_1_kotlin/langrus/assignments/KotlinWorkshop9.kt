@file:Suppress("unused")

package day_1_kotlin.langrus.assignments

// workshop #9 - generics
/*
 * Класс программиста, который может учить и забывать концепты на определенном языке.
 */

fun main() {
    val p = Programmer<Kotlin>()

    //TODO: uncomment all
    p.learn(Kotlin("basics"))

    p.learn(Kotlin("generics"))
    p.learn(Kotlin("coroutines"))

    println(p.howManyConceptsDoIKnow())
    // should be equal to 3

    println(p.lastConcept())
    //should be Kotlin(element=coroutines)

    p.forget(Kotlin("generics"))
    println(p.howManyConceptsDoIKnow())
    // should be equal to 2
}


class Programmer<T: Language> {
    private val myLanguages = mutableListOf<T>()

    fun howManyConceptsDoIKnow(): Int = myLanguages.size

    // TODO: add "learn" function with new concept
    fun learn(language: T) {
        myLanguages.add(language)
    }

    //TODO: add "forget" function with one concept to forget
    fun forget(language: T) {
        myLanguages.remove(language)
    }

    fun lastConcept(): T = myLanguages.last()
}

interface Language{
    val element: String
}

data class JavaLanguage(override val element: String) : Language
data class Kotlin(override val element: String): Language
data class Swift(override val element: String): Language
data class C_Sharp(override val element: String): Language

