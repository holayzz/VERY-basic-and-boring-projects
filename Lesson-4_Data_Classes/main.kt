package lesson4
// in next lesson ill create new project. gemini named it - "Space Survival Console"

data class Person(val name: String, val age: Int) // data class is cool

fun main() {
    val p1 = Person("(ne) oleg", 29)
    val p2 = Person("(ne) oleg", 29)
    if (p1 == p2) { // for fun
        println("okay, ${p1.name} is literally clone of ${p2.name}")
    } else {
        println("okay, ${p1.name} is literally not clone of ${p2.name}")
    }
}
