class EvenNumberComparator {
    fun getEvenNumber(prompt: String): Int {
        while (true) {
            print(prompt)
            val input = readLine()?.toIntOrNull()
            if (input != null && input % 2 == 0) {
                return input
            }
            println("Error: Ingresa un número par válido.")
        }
    }

    fun compareAndPrintLarger() {
        val num1 = getEvenNumber("Ingresa el primer número par: ")
        val num2 = getEvenNumber("Ingresa el segundo número par: ")

        val bigger = maxOf(num1, num2)
        println("Número más grande: $bigger\n")
    }
}