package com.dailyapps.expensecalc.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dailyapps.expensecalc.database.DatabaseWorker
import com.dailyapps.expensecalc.database.ExpenseDatabase
import com.dailyapps.expensecalc.model.Expense
import com.dailyapps.expensecalc.repository.ExpenseRepository
import com.dailyapps.expensecalc.util.DateUtils
import java.util.*
import javax.inject.Inject

class ExpenseViewModel @Inject constructor(val repository: ExpenseRepository) : ViewModel() {

    lateinit var allExpense: LiveData<List<Expense>>
    var selectedDate: MutableLiveData<String> = MutableLiveData()
    val selectedMonth: MutableLiveData<String> = MutableLiveData()
    var numberOfExpenseEntries: MutableLiveData<Int> = MutableLiveData()
    private lateinit var calendar: Calendar
    private var selectedPosition = -1

    fun init() {
        calendar = Calendar.getInstance()
        allExpense = repository.getExpensesByDay(calendar.time)
        numberOfExpenseEntries.value = 4
    }

    fun addExpense(expense: Expense) {
        executeDatabaseOperation(expense, false)
    }

    private fun executeDatabaseOperation(expense: Expense, isUpdate: Boolean) {
        val databaseOperation = DatabaseWorker(repository, expense, isUpdate)
        databaseOperation.execute()
    }

    fun onSelectedDayChanged(position: Int) {
        selectedPosition = when (selectedPosition) {
            -1 -> position
            else -> {
                calendar.add(Calendar.DAY_OF_WEEK, (position - selectedPosition))
                position
            }
        }
        setCurrentMonth()
        setCurrentDate()
    }

    private fun setCurrentDate() {
        calendar?.let {
            selectedDate.value = DateUtils.getDateTextFromTimestamp(it.timeInMillis)
        }
    }

    private fun setCurrentMonth() {
        calendar?.let {
            selectedMonth.value = DateUtils.getMonthTextFromTimestamp(it.timeInMillis)
        }
    }
}