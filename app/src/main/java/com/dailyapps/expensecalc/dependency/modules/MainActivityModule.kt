package com.dailyapps.expensecalc.dependency.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dailyapps.expensecalc.repository.ExpenseRepository
import com.dailyapps.expensecalc.viewmodel.ExpenseViewModel
import com.dailyapps.expensecalc.viewmodel.ViewModelProviderFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainActivityModule {

    @Provides
    @Singleton
    fun provideExpenseViewModel(expenseRepository: ExpenseRepository): ExpenseViewModel {
        return ExpenseViewModel(expenseRepository)
    }

    @Provides
    @Singleton
    fun provideViewModelFactory(expenseViewModel: ExpenseViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(expenseViewModel)
    }
}