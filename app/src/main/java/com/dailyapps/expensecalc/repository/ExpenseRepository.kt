package com.dailyapps.expensecalc.repository

import android.content.Context
import com.dailyapps.expensecalc.database.ExpenseDatabase
import com.dailyapps.expensecalc.model.Expense

class ExpenseRepository(context: Context) {

    private val expenseDao = ExpenseDatabase.getExpenseDatabase(context).getExpenseDao()

    val allExpenses = expenseDao.getExpenseByMonth()

    fun insert(expense: Expense) {
        expenseDao.insert(expense)
    }

    fun update(expense: Expense) {
        expenseDao.update(expense)
    }
}