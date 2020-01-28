package com.dailyapps.expensecalc.dependency.modules

import com.dailyapps.expensecalc.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun injectMainActivity(): MainActivity
}