package com.dailyapps.expensecalc.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dailyapps.expensecalc.ui.ViewExpenseFragment

class ExpenseViewAdapter(fragmentActivity: FragmentActivity):
    FragmentStateAdapter(fragmentActivity) {

    var expenseViewCount = 0

    override fun getItemCount(): Int {
        return expenseViewCount
    }

    override fun createFragment(position: Int) = ViewExpenseFragment.newInstance()
}