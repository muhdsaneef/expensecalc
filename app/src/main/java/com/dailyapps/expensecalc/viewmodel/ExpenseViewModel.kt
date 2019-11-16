package com.dailyapps.expensecalc.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dailyapps.expensecalc.database.DatabaseWorker
import com.dailyapps.expensecalc.database.ExpenseDatabase
import com.dailyapps.expensecalc.model.Expense
import com.dailyapps.expensecalc.repository.ExpenseRepository

class ExpenseViewModel : ViewModel() {

    private lateinit var repository: ExpenseRepository
    lateinit var allExpense: LiveData<List<Expense>>
    val selectedMonth: LiveData<String> = MutableLiveData()

    fun init(context: Context) {
        repository = ExpenseRepository(context)
        allExpense = repository.allExpenses
    }

    fun addExpense(expense: Expense) {
        executeDatabaseOperation(expense, false)
    }

    private fun executeDatabaseOperation(expense: Expense, isUpdate: Boolean) {
        val databaseOperation = DatabaseWorker(repository, expense, isUpdate)
        databaseOperation.execute()
    }

    fun onDateChanged() {

    }
}