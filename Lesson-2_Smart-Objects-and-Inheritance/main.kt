package lesson2

// im too lazy to add comments
open class Person(val name: String, val age: Int) {

    val isOleg: Boolean
        get() = name.lowercase() == "олег"

    fun canDrinkAlcohol(): Boolean {
        return age >= 18
    }

    open fun getInfo(): String {
        val olegStatus = if (isOleg) "ЛЕГЕНДА" else "Смертный"
        val drinkStatus = if (canDrinkAlcohol()) "Вход разрешен" else "Только сок"
        return "[$olegStatus] Имя: $name, Возраст: $age | Бар: $drinkStatus"
    }
}

class Admin(name: String, age: Int, val level: Int, val shift: String) : Person(name, age) {
    override fun getInfo(): String {
        return super.getInfo() + " [ROLE: ADMIN, LEVEL: $level, SHIFT: $shift]"
    }
}

val database = mutableListOf<Person>()

fun main() {
    while (true) {
        println("\n--- Database Admin Panel ---")
        print("Enter name (or 'print'/'exit'): ")
        val nameInput = readln()

        when (nameInput) {
            "exit" -> break
            "print" -> {
                println("\n--- Current Records ---")
                database.forEach { println(it.getInfo()) }
            }
            "admin_password_&sn*sn*nfKfKOfs*fkkaSSf}fF" -> {
                print("Enter age for $nameInput: ")
                val ageInput = readln().toIntOrNull() ?: 0

                print("Enter your level(only num): ")
                val levelInput = readln().toIntOrNull() ?: break

                print("Enter your shift for $nameInput: ")
                val shiftInput = readlnOrNull() ?: "idk"

                val newPerson = Admin(nameInput, ageInput, levelInput, shiftInput)
                database.add(newPerson)
                println("Added successfully!")
            }
            else -> {
                print("Enter age for $nameInput: ")
                val ageInput = readln().toIntOrNull() ?: 0

                val newPerson = Person(nameInput, ageInput)
                database.add(newPerson)
                println("Added successfully!")
            }
        }
    }
}