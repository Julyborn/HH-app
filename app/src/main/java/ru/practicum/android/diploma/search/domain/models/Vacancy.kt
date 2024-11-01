package ru.practicum.android.diploma.search.domain.models

data class Vacancy(
    val id: String,
    val name: String,
    val salary: Salary,
    val employer: Employer,
    val areaName: String,
    val selectedCountry: String,
    val selectedRegion: String,
    val industryId: String
)
