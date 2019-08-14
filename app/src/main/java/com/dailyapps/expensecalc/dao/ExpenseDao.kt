package com.dailyapps.expensecalc.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.dailyapps.expensecalc.model.Expense

@Dao
interface ExpenseDao {

    @Query("SELECT * from expense_table ORDER BY created_at DESC")
    fun getExpenseByMonth(): LiveData<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(expense: Expense)

    @Update
    fun update(expense: Expense)
}