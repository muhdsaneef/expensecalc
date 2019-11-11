package com.dailyapps.expensecalc.repository

import com.dailyapps.expensecalc.dao.ExpenseDao
import com.dailyapps.expensecalc.model.Expense

class ExpenseRepository(private val expenseDao: ExpenseDao) {
    val allNotes = expenseDao.getExpenseByMonth()

    fun insert(expense: Expense) {
        expenseDao.insert(expense)
    }

    fun update(expense: Expense) {
        expenseDao.update(expense)
    }
}