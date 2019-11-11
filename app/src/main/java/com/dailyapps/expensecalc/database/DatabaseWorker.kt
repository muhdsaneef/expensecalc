package com.dailyapps.expensecalc.database

import android.os.AsyncTask
import android.util.Log
import com.dailyapps.expensecalc.model.Expense
import com.dailyapps.expensecalc.repository.ExpenseRepository
import java.lang.ref.WeakReference

class DatabaseWorker(repository: ExpenseRepository,
                     private var expense: Expense,
                     isUpdate: Boolean) : AsyncTask<Void, Void, Boolean>() {
    private var weakActivityReference: WeakReference<ExpenseRepository> = WeakReference(repository)
    private var isUpdateOperation = isUpdate

    override fun doInBackground(vararg params: Void?): Boolean {
        if (weakActivityReference.get() != null) {
            if (isUpdateOperation) {
                weakActivityReference.get()?.update(expense)
            } else {
                weakActivityReference.get()?.insert(expense)
            }
            return true
        }
        return false
    }

    override fun onPostExecute(result: Boolean?) {
        result?.let {
            Log.d("DatabaseWorker status ", it.toString())
        }
    }
}