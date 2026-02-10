// TODO: все сделано ;)

// gemini, мои лапки уже хотят спать (хотя, скорее всего, логично - я не делаю MVP Безделушку, а MVP Безделушку Pro)

// не в функциях, ведь скрипт мелкий. пока можно ;)

// переменные
class Person(val name: String, val isOleg: Boolean) // шаблон для удобства
val database = mutableListOf<Person>() // бд (туда лучше не лезть во время работы программы(т.е всегда))
var olegCount = 0 // счетчик олегов

// все доступные команды
fun nameallcommands() {
    println("commands = print all commands, print = print all names,\nclear = clear database, exit = exit")
}

// показ базы данных + количество олегов
fun nameallnames() {
    // пока всех челов не перечислим (10/10, например)
    for (person in database) {
        // чекаем статус олега
        val status = if (person.isOleg) "ДА" else "нет"
        // докс
        println("Имя: ${person.name}, он Олег? $status")
    }
    // для удобства
    print("общее кол-во Олегов: $olegCount")
}

// паник мод, наверное
fun cleardatabase() {
    database.clear() // удаление
    println("официальная база стерта, если база данных есть в интернете - она не удалится!")
}

// основной бро
fun main() {
    // пока true
    while(true) {
        // приветственный экранчик
        println("--- name database (type \"олег\"!) ---")
        println("--- all commands: \"commands\" ---")
        print("A:")
        // регаем инпут
        val olegram: String = readln()
        // незаменимая и очень полезная штука when. без "чем гуще лес - if else, if else"
        when (olegram) {
            // база
            "commands" -> nameallcommands()
            "print" -> nameallnames()
            "clear" -> cleardatabase()
            "exit" -> break
            "олег" -> {
                olegCount++ // регаем олега
                val newPerson = Person(name = olegram, isOleg = olegram.lowercase() == "олег") // чтоб это кинуть в бд
                database.add(newPerson) // сейвим

            }
            // тоже самое, без олега
            else -> {
                val newPerson = Person(name = olegram, isOleg = olegram.lowercase() == "олег")
                database.add(newPerson)
            }
        }
    }
}