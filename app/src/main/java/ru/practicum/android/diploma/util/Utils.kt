package ru.practicum.android.diploma.util

import ru.practicum.android.diploma.search.domain.models.Salary

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
        fromSalary != null && toSalary != null -> "от $fromSalary до $toSalary $currencySymbol"
        fromSalary != null -> "от $fromSalary $currencySymbol"
        toSalary != null -> "до $toSalary $currencySymbol"
        else -> "Зарплата не указана"
    }
}
