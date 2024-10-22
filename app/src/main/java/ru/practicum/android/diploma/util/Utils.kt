package ru.practicum.android.diploma.util

import ru.practicum.android.diploma.search.domain.models.Salary
import java.text.NumberFormat
import java.util.Locale

fun formatSalary(salary: Int): String {
    val formatter = NumberFormat.getInstance(Locale("ru", "RU"))
    return formatter.format(salary)
}

fun Salary?.formatSalary(): String {
    if (this == null) {
        return "Зарплата не указана"
    }

    val fromSalary = this.from
    val toSalary = this.to
    val currencySymbol = when (this.currency) {
        "RUR" -> "₽"
        "USD" -> "$"
        "EUR" -> "€"
        "GBP" -> "£"
        "JPY" -> "¥"
        "CNY" -> "¥"
        "INR" -> "₹"
        "KRW" -> "₩"
        "BRL" -> "R$"
        "TRY" -> "₺"
        else -> this.currency
    }

    return when {
        fromSalary != null && toSalary != null -> "от ${formatSalary(fromSalary)} до ${formatSalary(toSalary)} $currencySymbol"
        fromSalary != null -> "от ${formatSalary(fromSalary)} $currencySymbol"
        toSalary != null -> "до ${formatSalary(toSalary)} $currencySymbol"
        else -> "Зарплата не указана"
    }
}
