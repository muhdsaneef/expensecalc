package com.dailyapps.expensecalc.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.dailyapps.expensecalc.R

/**
 * A simple [Fragment] subclass.
 */
class ViewExpenseFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_expense, container, false)
    }

    companion object {
        fun newInstance() = ViewExpenseFragment()
    }

}
