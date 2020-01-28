package com.dailyapps.expensecalc.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dailyapps.expensecalc.model.Expense

@Dao
interface ExpenseDao {

    @Query("SELECT * from expense_table ORDER BY created_at DESC")
    fun getAllExpenses(): LiveData<List<Expense>>

    @Query("SELECT * from expense_table WHERE created_at BETWEEN :dayStartTime " +
            "AND :dayEndTime ORDER BY created_at DESC")
    fun getExpensesByDay(dayStartTime: Long, dayEndTime: Long): LiveData<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(expense: Expense)

    @Update
    fun update(expense: Expense)

    @Query("SELECT COUNT(*) from expense_table WHERE created_at BETWEEN :monthStartDate " +
            "AND :monthEndDate ORDER BY created_at DESC")
    fun getNumberOfEntriesInGivenMonth(monthStartDate: Long, monthEndDate: Long): LiveData<Int>
}