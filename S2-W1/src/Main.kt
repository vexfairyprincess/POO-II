/**
 * Shows a menu that loops until the user chooses to exit. Calls the appropriate
 * function based on the option selected.
 */
fun main() {
    while (true) {
        println("Select an option:")
        println("1) Compare two even numbers")
        println("2) Calculate average of ages")
        println("3) Count vowels in a phrase")
        println("4) Exit")
        print("Enter your choice: ")
        when (readLine()?.toIntOrNull()) {
            1 -> {
                EvenNumberComparator().compareAndPrintLarger()
            }
            2 -> calculateAgesAverage()
            3 -> countPhraseVowels()
            4 -> {
                println("Exiting...")
                return
            }
            else -> println("Invalid choice, try again.\n")
        }
    }
}

/**
 * Reads two even numbers and prints the larger one.
 * If any of the numbers is not even, prints a warning message.
 */


fun compareEvenNumbers() {
    print("Enter the first even number: ")
    val num1 = readLine()?.toIntOrNull() ?: return
    print("Enter the second even number: ")
    val num2 = readLine()?.toIntOrNull() ?: return

    if (num1 % 2 != 0 || num2 % 2 != 0) {
        println("Please enter even numbers only.\n")
        return
    }
    val bigger = if (num1 > num2) num1 else num2
    println("Bigger number: $bigger\n")
}

/**
 * Reads a specified number of ages, sums them, and prints the average.
 * If zero ages are provided, the average is 0.0.
 */
fun calculateAgesAverage() {
    print("How many ages? ")
    val count = readLine()?.toIntOrNull() ?: return
    var sum = 0

    for (i in 1..count) {
        print("Enter age $i: ")
        sum += readLine()?.toIntOrNull() ?: 0
    }
    val average = if (count > 0) sum.toDouble() / count else 0.0
    println("Average age is: $average\n")
}

/**
 * Reads a phrase and prints the number of vowels contained in it.
 */
fun countPhraseVowels() {
    print("Enter a phrase: ")
    val phrase = readLine()?.lowercase() ?: return
    val vowels = listOf('a', 'e', 'i', 'o', 'u')
    val count = phrase.count { it in vowels }
    println("Number of vowels: $count\n")
}