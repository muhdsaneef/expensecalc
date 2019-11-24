package com.dailyapps.expensecalc.util

import androidx.lifecycle.MutableLiveData
import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    private const val DATE_FORMAT = "dd/MM/yyyy"
    private const val MONTH_FORMAT = "MMMM"

    fun getDateTextFromTimestamp(timestamp: Long): String {
        val date = Date()
        date.time = timestamp
        val dateFormatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return dateFormatter.format(date)
    }

    fun getMonthTextFromTimestamp(timestamp: Long): String {
        val date = Date()
        date.time = timestamp
        val dateFormatter = SimpleDateFormat(MONTH_FORMAT, Locale.getDefault())
        return dateFormatter.format(date)
    }

    fun getDayStartAndEnd(selectedDate: Date): Pair<Long, Long> {
        val calendar = Calendar.getInstance()
        calendar.time = selectedDate
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        val dayStartTime = calendar.time.time
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        val dayEndTime = calendar.time.time
        return Pair(dayStartTime, dayEndTime)
    }
}