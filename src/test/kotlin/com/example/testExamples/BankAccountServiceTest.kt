package com.example.testExamples

import io.mockk.*
import io.mockk.impl.annotations.MockK
import org.amshove.kluent.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BankAccountServiceTest {


    @Nested
    inner class CreateAccountBank {

        @MockK
        lateinit var bankAccountRepository: BankAccountRepository

        init {
            MockKAnnotations.init(this)
        }

        private val service = BankAccountService(bankAccountRepository)

        @Test
        fun `should be able to initialise service`() {
            service.shouldNotBeNull()
        }

        @Test
        fun `should add a new account bank and get an account`() {
            val bankAccount = BankAccount("John Joe", "0001")

            every { bankAccountRepository.add(bankAccount) } just Runs
            every { bankAccountRepository.get("0001") } returns bankAccount

            invoking { service.createAccountBank(bankAccount) }`should not throw` AnyException
            service.getAccountBank("0001").name `should be` "John Joe"
        }
    }
}