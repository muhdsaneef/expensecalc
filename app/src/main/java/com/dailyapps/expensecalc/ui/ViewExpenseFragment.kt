package com.dailyapps.expensecalc.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.dailyapps.expensecalc.R
import com.dailyapps.expensecalc.adapters.ExpensesAdapter
import com.dailyapps.expensecalc.viewmodel.ExpenseViewModel
import kotlinx.android.synthetic.main.fragment_view_expense.*

class ViewExpenseFragment : Fragment() {
    
    private lateinit var viewModel: ExpenseViewModel
    private lateinit var adapter: ExpensesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_view_expense, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
        initExpensesAdapter()
        setObserverExpensesListChanges()
    }

    private fun initViewModel() {
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(ExpenseViewModel::class.java)
        }
    }

    private fun initExpensesAdapter() {
        adapter = ExpensesAdapter()
        rv_expenses_list.adapter = adapter


    }

    private fun setObserverExpensesListChanges() {
        viewModel.allExpense.observe(this, Observer{expenseList ->
            adapter.setExpenses(expenseList)
        })

        viewModel.selectedDate.observe(this, Observer {
            tv_current_date.text = it
        })

        viewModel.selectedMonth.observe(this, Observer {
            tv_current_month.text = getString(R.string.tv_current_month, it)
        })
    }

    companion object {
        fun newInstance() = ViewExpenseFragment()
    }

}
