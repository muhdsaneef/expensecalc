package com.dailyapps.expensecalc.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dailyapps.expensecalc.ui.ViewExpenseFragment

class ExpenseViewAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity) {

    private val expenseViewList = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int) = ViewExpenseFragment.newInstance()
}