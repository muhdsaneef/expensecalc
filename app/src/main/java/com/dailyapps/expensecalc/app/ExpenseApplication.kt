package com.dailyapps.expensecalc.app

import android.app.Application
import com.dailyapps.expensecalc.dependency.components.DaggerExpenseAppComponent
import com.dailyapps.expensecalc.dependency.components.ExpenseAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.HasAndroidInjector

class ExpenseApplication: DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerExpenseAppComponent.builder().application(this).build()
    }


}