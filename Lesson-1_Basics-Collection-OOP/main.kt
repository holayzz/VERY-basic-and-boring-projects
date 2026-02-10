// london is the capital of great britian
// TODO: everything is done ;)

// Gemini, my paws want to sleep (makes sense though - I'm not building a basic Toy MVP, but a Toy Pro MVP)

// Not using functions for logic here since the script is tiny. For now, it's fine ;)

// Variables
class Person(val name: String, val isOleg: Boolean) // Template for convenience
val database = mutableListOf<Person>() // DB (better not touch this while the program is running (meaning: never))
var olegCount = 0 // Oleg counter

// Show all available commands
fun nameallcommands() {
    println("commands = print all commands, print = print all names,\nclear = clear database, exit = exit")
}

// Show database content + Oleg count
fun nameallnames() {
    // Iterate through all people (e.g., 10/10)
    for (person in database) {
        // Check Oleg status
        val status = if (person.isOleg) "YES" else "no"
        // Doxxing
        println("Name: ${person.name}, is he Oleg? $status")
    }
    // For convenience
    print("Total number of Olegs: $olegCount")
}

// Panic mode, I guess
fun cleardatabase() {
    database.clear() // Deleting
    println("The official database has been wiped. If it's leaked online, it won't be deleted there!")
}

// The main bro
fun main() {
    // Keep going while true
    while(true) {
        // Welcome screen
        println("--- name database (type \"олег\"!) ---")
        println("--- all commands: \"commands\" ---")
        print("A:")

        // Register input
        val olegram: String = readln()

        // The indispensable and very useful 'when'. Avoiding the "if-else forest"
        when (olegram) {
            // Standard commands
            "commands" -> nameallcommands()
            "print" -> nameallnames()
            "clear" -> cleardatabase()
            "exit" -> break
            "олег" -> {
                olegCount++ // Registering an Oleg
                val newPerson = Person(name = olegram, isOleg = olegram.lowercase() == "олег") // Preparing for DB
                database.add(newPerson) // Saving
            }
            // Same thing, but not an Oleg
            else -> {
                val newPerson = Person(name = olegram, isOleg = olegram.lowercase() == "олег")
                database.add(newPerson)
            }
        }
    }
}