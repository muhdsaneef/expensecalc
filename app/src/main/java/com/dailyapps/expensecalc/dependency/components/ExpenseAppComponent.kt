package com.dailyapps.expensecalc.dependency.components

import com.dailyapps.expensecalc.MainActivity
import com.dailyapps.expensecalc.app.ExpenseApplication
import com.dailyapps.expensecalc.dependency.modules.ActivityBindingModule
import com.dailyapps.expensecalc.dependency.modules.ExpenseAppModule
import com.dailyapps.expensecalc.dependency.modules.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(modules = [AndroidInjectionModule::class, ExpenseAppModule::class, MainActivityModule::class, ActivityBindingModule::class])
@Singleton
interface ExpenseAppComponent: AndroidInjector<ExpenseApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: ExpenseApplication): Builder

        fun build(): ExpenseAppComponent
    }
}