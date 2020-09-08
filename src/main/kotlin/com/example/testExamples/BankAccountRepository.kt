package com.example.testExamples

import org.springframework.stereotype.Repository

@Repository
class BankAccountRepository() {
    fun add(account: BankAccount) {
        TODO("Not yet implemented")
    }

    fun get(numberAccount: String): BankAccount {
        return BankAccount("name", "numberAccount")
    }
}