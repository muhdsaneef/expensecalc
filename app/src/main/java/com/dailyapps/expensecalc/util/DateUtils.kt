package com.dailyapps.expensecalc.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    private const val DATE_FORMAT = "dd/MM/yyyy"

    fun getDateTextFromTimestamp(timestamp: Long): String {
        val date = Date()
        date.time = timestamp
        val dateFormatter = SimpleDateFormat(DATE_FORMAT, Locale.getDefault())
        return dateFormatter.format(date)
    }
}