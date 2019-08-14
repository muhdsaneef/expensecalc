package com.dailyapps.expensecalc.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense_table")
class Expense(@PrimaryKey @ColumnInfo(name = "id") val id: String,
              @ColumnInfo(name = "expense_name") val expenseName: String,
              @ColumnInfo(name = "created_at") var createdAt: Long,
              @ColumnInfo(name = "expense_description") var expenseDescription: String) {
}