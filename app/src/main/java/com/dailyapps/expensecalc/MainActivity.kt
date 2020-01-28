package com.dailyapps.expensecalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.dailyapps.expensecalc.adapters.ExpenseViewAdapter
import com.dailyapps.expensecalc.databinding.ActivityMainBinding
import com.dailyapps.expensecalc.model.Expense
import com.dailyapps.expensecalc.viewmodel.ExpenseViewModel
import com.dailyapps.expensecalc.viewmodel.ViewModelProviderFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var factory: ViewModelProviderFactory

    private lateinit var viewModel: ExpenseViewModel
    private lateinit var adapter: ExpenseViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        AndroidInjection.inject(this)
        initExpenseViewAdapter()
        initViewModel()
        setExpensesView()
        initAddExpense()
    }

    private fun initExpenseViewAdapter() {
        adapter = ExpenseViewAdapter(this)
    }

    private fun setExpensesView() {
        view_pager.adapter = adapter
        viewModel.numberOfExpenseEntries.observe(this, androidx.lifecycle.Observer {
            adapter.expenseViewCount = it
            view_pager.currentItem = it
        })
        view_pager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.onSelectedDayChanged(position)
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this, factory).get(ExpenseViewModel::class.java)
        viewModel.init()
    }

    private fun initAddExpense() {
        btn_add_expense.setOnClickListener {
            val timestamp = System.currentTimeMillis()
            viewModel.addExpense(
                Expense(
                    UUID.randomUUID().toString(),
                    "Food",
                    250.50,
                    timestamp,
                    Date(timestamp),
                    "Rahmath")
            )
        }

    }

}
