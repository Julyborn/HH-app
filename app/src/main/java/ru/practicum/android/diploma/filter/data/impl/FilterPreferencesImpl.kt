package ru.practicum.android.diploma.filter.data.impl

import android.content.Context
import android.content.SharedPreferences
import ru.practicum.android.diploma.filter.data.dto.FilterSettings
import ru.practicum.android.diploma.filter.domain.api.FilterPreferences
import ru.practicum.android.diploma.filter.domain.models.FilterParams

class FilterPreferencesImpl(context: Context) : FilterPreferences {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("filter_prefs", Context.MODE_PRIVATE)

    override fun saveFilters(params: FilterParams) {
        sharedPreferences.edit().apply {
            putString(KEY_LOCATION, params.location)
            putString(KEY_INDUSTRY, params.industry)
            putString(KEY_SALARY, params.salary)
            putString(KEY_INDUSTRY_ID, params.industryId)
            putBoolean(KEY_HIDE_WITHOUT_SALARY, params.hideWithoutSalary)
            putString(KEY_SELECTED_AREA, params.area)
            apply()
        }
    }

    override fun getFilters(): FilterSettings {
        val location = sharedPreferences.getString(KEY_LOCATION, null)
        val industry = sharedPreferences.getString(KEY_INDUSTRY, null)
        val salary = sharedPreferences.getString(KEY_SALARY, null)
        val industryId = sharedPreferences.getString(KEY_INDUSTRY_ID, null)
        val hideWithoutSalary = sharedPreferences.getBoolean(KEY_HIDE_WITHOUT_SALARY, false)
        val selectedArea = sharedPreferences.getString(KEY_SELECTED_AREA, null)
        return FilterSettings(
            location,
            industry,
            salary,
            industryId,
            hideWithoutSalary,
            selectedArea
        )
    }

    override fun clearFilters() {
        sharedPreferences.edit().clear().apply()
    }

    companion object {
        private const val KEY_LOCATION = "key_location"
        private const val KEY_INDUSTRY = "key_industry"
        private const val KEY_SALARY = "key_salary"
        private const val KEY_INDUSTRY_ID = "key_industry_id"
        private const val KEY_HIDE_WITHOUT_SALARY = "key_hide_without_salary"
        private const val KEY_SELECTED_AREA = "key_selected_area"
    }
}
