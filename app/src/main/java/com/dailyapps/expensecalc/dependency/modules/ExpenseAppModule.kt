package com.dailyapps.expensecalc.dependency.modules

import android.content.Context
import com.dailyapps.expensecalc.app.ExpenseApplication
import com.dailyapps.expensecalc.dao.ExpenseDao
import com.dailyapps.expensecalc.database.ExpenseDatabase
import com.dailyapps.expensecalc.repository.ExpenseRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ExpenseAppModule {

    @Singleton
    @Provides
    fun provideAppContext(expenseApplication: ExpenseApplication): Context {
        return expenseApplication
    }

    @Singleton
    @Provides
    fun provideExpenseDatabaseDao(context: Context): ExpenseDao {
        return ExpenseDatabase.getExpenseDatabase(context).getExpenseDao()
    }

    @Singleton
    @Provides
    fun provideExpenseRepository(expenseDao: ExpenseDao) : ExpenseRepository {
        return ExpenseRepository(expenseDao)
    }
}