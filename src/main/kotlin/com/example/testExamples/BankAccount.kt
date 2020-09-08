package com.example.testExamples


class BankAccount(val name: String, val numberAccount: String) {
    var balance: Double = 0.0
    var limit: Double = 0.0

    fun updateBalance(value: Double) {
        val newBalance = balance + value
        if (newBalance < (limit * (-1))) {
            throw IllegalArgumentException("Limit not authorized")
        }
        balance = newBalance
    }
}