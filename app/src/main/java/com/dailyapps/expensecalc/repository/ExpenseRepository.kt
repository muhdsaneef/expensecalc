package com.dailyapps.expensecalc.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dailyapps.expensecalc.dao.ExpenseDao
import com.dailyapps.expensecalc.database.ExpenseDatabase
import com.dailyapps.expensecalc.model.Expense
import com.dailyapps.expensecalc.util.DateUtils
import java.util.*
import javax.inject.Inject

class ExpenseRepository @Inject constructor(val expenseDao: ExpenseDao) {

    val allExpenses = expenseDao.getAllExpenses()

    fun getNumberOfEntries(it: List<Expense>): Int {
            var count = 0
            for (i in 1..it.size) {
                val expenseDateFirst = it[i].createdAt / 1000000
                val expenseDateSecond = it[i-1].createdAt / 1000000
                if (expenseDateFirst != expenseDateSecond) {
                    count += 1
                }
            }
            return count
    }

    fun getExpensesByDay(selectedDate: Date): LiveData<List<Expense>> {
        val dayStartAndEnd = DateUtils.getDayStartAndEnd(selectedDate)
        return expenseDao.getExpensesByDay(dayStartAndEnd.first, dayStartAndEnd.second)
    }

    fun getNumberOfEntriesInGivenMonth(monthStartDate: Long, monthEndDate: Long): LiveData<Int> {
        return expenseDao.getNumberOfEntriesInGivenMonth(monthStartDate, monthEndDate)
    }

    fun insert(expense: Expense) {
        expenseDao.insert(expense)
    }

    fun update(expense: Expense) {
        expenseDao.update(expense)
    }
}