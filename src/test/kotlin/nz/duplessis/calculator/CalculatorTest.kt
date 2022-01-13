package nz.duplessis.calculator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertDoesNotThrow

internal class CalculatorTest {

    private val calculator = Calculator()

    @Test
    @DisplayName("Should return the correct operator")
    fun testOperatorReturn() {
        Assertions.assertEquals("+", calculator.operator("1+2"), "1+2 should return +")
        Assertions.assertEquals("-", calculator.operator("1-2"), "1-2 should return -")
        Assertions.assertEquals("*", calculator.operator("1*2"), "1*2 should return *")
        Assertions.assertEquals("/", calculator.operator("1/2"), "1/2 should return /")
        Assertions.assertEquals("quit", calculator.operator("q"), "quit command")
        Assertions.assertEquals("quit", calculator.operator("Q"), "quit command")
        Assertions.assertEquals("quit", calculator.operator("qUit"), "quit command")
        Assertions.assertEquals("-", calculator.operator("-2"), " Null input should return ~")

    }

    @Test
    @DisplayName("It should throw an exception if it dose not recognise the operator")
    fun testOperatorException() {
        assertThrows(IllegalArgumentException::class.java, { calculator.operator("1 2") }, "Should throw")
        assertThrows(IllegalArgumentException::class.java, { calculator.operator("1!2") }, "Should throw")
        assertThrows(IllegalArgumentException::class.java, { calculator.operator("1  ^ 2") }, "Should throw")
    }

    @Test
    @DisplayName("Check that the input has two legal operands")
    fun testOperands() {
        Assertions.assertEquals(arrayListOf("1","2"), calculator.operands("1+2"),
            "1+2 should return 1 and 2")
        Assertions.assertNotEquals(arrayListOf("1","2"), calculator.operands("1+3"),
            "1+2 should return 1 and 2")
        Assertions.assertEquals(arrayListOf("1","2"), calculator.operands("1 + 2"),
            "1+2 should return 1 and 2")
        Assertions.assertEquals(arrayListOf("1","2"), calculator.operands("1 +2"),
            "1+2 should return 1 and 2")

    }

    @Test
    @DisplayName("test Calculations")
    fun testCalculate() {
        Assertions.assertEquals(
            3.0, calculator.calculate("1+2"),
           "1+2 should return 3.0",
        )
        Assertions.assertEquals(
            -1.0, calculator.calculate("1-2"),
            "1+2 should return 3.0",
        )
        Assertions.assertEquals(
            -2.0, calculator.calculate("0-2"),
            "0-2 should return -2.0",
        )
        Assertions.assertEquals(
            2.0, calculator.calculate("1*2"),
            "1+2 should return 3.0",
        )
        Assertions.assertEquals(
            0.5, calculator.calculate("1/2"),
            "1+2 should return 3.0",
        )
        Assertions.assertEquals(
            2.0, calculator.calculate("0+2"),
            "0+2 should return 2.0",
        )
        Assertions.assertEquals(
            5.0, calculator.calculate("10/2"),
            "10/2 should return 5.0",
        )
        Assertions.assertEquals(
            2.5, calculator.calculate("5/2"),
            "5/2 should return 2.5",
        )


    }
    @Test
    @DisplayName("It should throw an exception if it dose not recognise the operator")
    fun testCalculationException() {
        Assertions.assertThrows(Exception::class.java, { calculator.calculate("1/0") }, "Should throw")
        Assertions.assertThrows(Exception::class.java, { calculator.calculate("1/") }, "Should throw")
        Assertions.assertThrows(Exception::class.java, { calculator.calculate("/2") }, "Should throw")
        Assertions.assertThrows(Exception::class.java, { calculator.calculate("") }, "Should throw")
        Assertions.assertThrows(Exception::class.java, { calculator.calculate("%") }, "Should throw")
        Assertions.assertThrows(Exception::class.java, { calculator.calculate("+%") }, "Should throw")
        Assertions.assertThrows(Exception::class.java, { calculator.calculate("%+5") }, "Should throw")
    }
}