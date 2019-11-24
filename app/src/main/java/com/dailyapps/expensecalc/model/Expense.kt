package com.dailyapps.expensecalc.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "expense_table")
data class Expense(@PrimaryKey @ColumnInfo(name = "id") val id: String,
                   @ColumnInfo(name = "expense_name") val expenseName: String,
                   @ColumnInfo(name = "expense_amount") val expenseAmount: Double,
                   @ColumnInfo(name = "created_at") var createdAt: Long,
                   @ColumnInfo(name = "expense") var expenseDate: Date?,
                   @ColumnInfo(name = "expense_description") var expenseDescription: String) {
}