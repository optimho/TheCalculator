package nz.duplessis.calculator

class Calculator {


    fun operator(input: String): String {
        var operandor: String = " "

        operandor = when {
            input.contains("+") -> "+"
            input.contains("-") -> "-"
            input.contains("/") -> "/"
            input.contains("*") -> "*"
            input.lowercase().contains("q") -> "quit"
            input.lowercase().contains("quit") -> "quit"
            input.lowercase().contains("go") -> "go"
            else -> throw IllegalArgumentException("Invalid Operator $operandor")
        }
        //println(operandor)
        return operandor
    }

    fun operands(input: String): List<String> {

        var myValues: List<String> = input.replace("\\s".toRegex(), "")
            .toString()
            .split("+", "-", "/", "*","q")

        if (myValues[0].isEmpty() || myValues[1].isEmpty()) {
            throw IllegalArgumentException("needs two operands")
        }
        //println(myValues[0])
        //println(myValues[1])


        return myValues

    }

    fun calculate(input: String) :Double {
        var result:Double =0.0


        if (input.isNotBlank() || !input.contains("quit")) {
            val operandsForCalculation = operands(input)
        }
            when (operator(input)) {
                "+" -> {
                   // println("add")
                    result= operands(input)[0].toDouble() + operands(input)[1].toDouble()
                }
                "-" -> {
                   // println("minus")
                    result= operands(input)[0].toDouble() - operands(input)[1].toDouble()
                }
                "*" -> {
                   // println("multiply")
                    result= operands(input)[0].toDouble() * operands(input)[1].toDouble()
                }
                "/" -> {
                    //println("divide")
                    if (operands(input)[1].toDouble() == 0.0) throw Exception("Divide by zero")
                    try {

                        result= operands(input)[0].toDouble() / operands(input)[1].toDouble()
                    } catch (ex: Exception) {
                        println("Fault in calculation")
                    }


                }
                else -> {
                    throw IllegalArgumentException("invalid operator:")
                }
         //   }
        }
    return result
    }
}