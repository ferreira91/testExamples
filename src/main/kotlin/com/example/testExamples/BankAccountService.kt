package com.example.testExamples

import org.springframework.stereotype.Service

@Service
class BankAccountService(val accountRepository: BankAccountRepository) {

    fun createAccountBank(bankAccount: BankAccount) {
        accountRepository.add(bankAccount)
    }

    fun getAccountBank(numberAccount: String): BankAccount {
        return accountRepository.get(numberAccount)
    }
}