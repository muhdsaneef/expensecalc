package com.dailyapps.expensecalc.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.dailyapps.expensecalc.dao.ExpenseDao
import com.dailyapps.expensecalc.model.Expense
import java.util.*
import java.util.concurrent.Executors

@Database(entities = [Expense::class], version = 1)
abstract class ExpenseDatabase: RoomDatabase() {
    abstract fun getExpenseDao(): ExpenseDao

    companion object {
        @Volatile
        private var INSTANCE: ExpenseDatabase? = null

        fun getExpenseDatabase(context: Context): ExpenseDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ExpenseDatabase::class.java,
                    "Expenses_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}