package com.example.testExamples

import org.amshove.kluent.*
import org.junit.jupiter.api.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankAccountTest {

    private val bankAccount = BankAccount("649.412.010-51", "John Joe")

    @Nested
    inner class UpdateBalance {

        @BeforeEach
        fun init() {
            bankAccount.balance = 0.0
        }

        @Test
        fun `should be able to increase balance`() {
            bankAccount.updateBalance(100.0)
            bankAccount.balance.shouldBeEqualTo(100.0)
            bankAccount.balance.`should be equal to`(100.0)
            bankAccount.balance `should be equal to` 100.0
        }

        @Test
        fun `should be able to decrease balance`() {
            bankAccount.updateBalance(100.0)
            bankAccount.updateBalance(-50.0)
            Assertions.assertEquals(50.0, bankAccount.balance)
            bankAccount.balance.shouldBeEqualTo(50.0)
            bankAccount.balance.`should be equal to`(50.0)
            bankAccount.balance `should be equal to` 50.0
        }

        @Test
        fun `should throw an exception if balance exceed the limit`() {
            bankAccount.updateBalance(50.0)
            Assertions.assertThrows(IllegalArgumentException::class.java) {
                bankAccount.updateBalance(-100.00)
            }
            invoking { bankAccount.updateBalance(-100.00) }.shouldThrow(java.lang.IllegalArgumentException::class)
        }

        @Test
        fun `should not throw an exception if balance not exceed the limit`() {
            bankAccount.updateBalance(150.0)
            Assertions.assertDoesNotThrow() {
                bankAccount.updateBalance(-100.00)
            }
            invoking { bankAccount.updateBalance(-25.00) }.shouldNotThrow(java.lang.IllegalArgumentException::class)
        }
    }
}