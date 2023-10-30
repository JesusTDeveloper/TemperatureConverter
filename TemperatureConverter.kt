// Constante que define el valor de 0°C en Kelvin
const val ZERO_CELSIUS_IN_KELVIN = 273

fun main() {
    menu()
}

/**
 * Muestra un menú de opciones de conversión de temperatura.
 */
fun menu() {
    var option: String?

    // Dependiendo de la opción ingresada, se ejecuta la función correspondiente.
    do {
        println("Conversor de Temperatura\nIngresa una opción:\n" +
                "1) C° a F°\n2) F° a C°\n3) C° a K\n4) K a C°\n5) F° a K\n6) K a F°")

        option = readln()

        when(option) {
            "1" -> celsiusToFahrenheit()
            "2" -> fahrenheitToCelsius()
            "3" -> celsiusToKelvin()
            "4" -> kelvinToCelsius()
            "5" -> fahrenheitToKelvin()
            "6" -> kelvinToFahrenheit()
            else -> {
                println("Ingresa una opción válida")
                option = null
            }
        }
    } while (option == null)

}

/**
 * Solicita al usuario un número y lo retorna.
 * Si el valor ingresado no es un número, vuelve a solicitarlo.
 * @return el valor numérico ingresado por el usuario.
 */
fun getNum(): Double {
    var input: String?
    var number: Double?

    do {
        input = readln()
        number = input.toDoubleOrNull()

        if (number == null) {
            println("Debe ingresar un valor numérico")
        }
    } while (number == null)

    return number
}

/**
 * Imprime un mensaje solicitando al usuario que ingrese un valor.
 * @param message el tipo de temperatura que se quiere convertir (por ejemplo: "C°", "F°", "K").
 */
fun inputMessage(message: String) {
    println("Ingresa el valor de $message:")
}

/**
 * Convierte un valor de Celsius a Fahrenheit e imprime el resultado.
 */
fun celsiusToFahrenheit() {
    inputMessage("C°")
    val celsius = getNum()
    val fahrenheit = (1.8 * celsius) + 32
    println("%.2f C° = %.2f F°".format(celsius, fahrenheit))
}

/**
 * Convierte un valor de Fahrenheit a Celsius e imprime el resultado.
 */
fun fahrenheitToCelsius() {
    inputMessage("F°")
    val fahrenheit = getNum()
    val celsius = (fahrenheit - 32) / 1.8
    println("$%.2f F° = %.2f C°".format(fahrenheit, celsius))
}

/**
 * Convierte un valor de Celsius a Kelvin e imprime el resultado.
 */
fun celsiusToKelvin() {
    inputMessage("C°")
    val celsius = getNum()
    val kelvin = celsius + ZERO_CELSIUS_IN_KELVIN
    println("%.2f C° = %.2f K".format(celsius, kelvin))
}

/**
 * Convierte un valor de Kelvin a Celsius e imprime el resultado.
 */
fun kelvinToCelsius() {
    inputMessage("K")
    val kelvin = getNum()
    val celsius = kelvin - ZERO_CELSIUS_IN_KELVIN
    println("%.2f K = %.2f C°".format(kelvin, celsius))
}

/**
 * Convierte un valor de Fahrenheit a Kelvin e imprime el resultado.
 */
fun fahrenheitToKelvin() {
    inputMessage("F°")
    val fahrenheit = getNum()
    val celsius = (fahrenheit - 32) / 1.8
    val kelvin = celsius + ZERO_CELSIUS_IN_KELVIN
    println("%.2f F° = %.2f K".format(fahrenheit, kelvin))
}

/**
 * Convierte un valor de Kelvin a Fahrenheit e imprime el resultado.
 */
fun kelvinToFahrenheit() {
    inputMessage("K")
    val kelvin = getNum()
    val celsius = kelvin - ZERO_CELSIUS_IN_KELVIN
    val fahrenheit = (1.8 * celsius) + 32
    println("%.2f K = %.2f F° ".format(kelvin, fahrenheit))
}