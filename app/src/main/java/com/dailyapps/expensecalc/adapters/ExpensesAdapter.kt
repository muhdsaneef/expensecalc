package com.dailyapps.expensecalc.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dailyapps.expensecalc.R
import com.dailyapps.expensecalc.model.Expense
import com.dailyapps.expensecalc.util.DateUtils
import kotlinx.android.synthetic.main.item_expense.view.*

class ExpensesAdapter: RecyclerView.Adapter<ExpensesAdapter.ViewHolder>() {

        private var expenseList = emptyList<Expense>()

        override fun getItemCount(): Int {
            return expenseList.size
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
            val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_expense, viewGroup, false)
            return ViewHolder(itemView)
        }

        override fun onBindViewHolder(viweHolder: ViewHolder, position: Int) {
            viweHolder.itemView.tv_expense_name.text = expenseList[position].expenseName
            viweHolder.itemView.tv_expense_amount.text = expenseList[position].expenseAmount.toString()
            viweHolder.itemView.tv_expense_description.text = expenseList[position].expenseDescription
            viweHolder.itemView.tv_expense_created_on.text = DateUtils.getDateTextFromTimestamp(expenseList[position].createdAt)
        }

        fun setExpenses(notes: List<Expense>) {
            expenseList = notes
            notifyDataSetChanged()
        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}