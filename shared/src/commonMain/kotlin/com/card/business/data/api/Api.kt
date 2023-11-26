package com.card.business.data.api

import com.card.business.data.dto.EmployeeDto

interface Api {

    suspend fun fetchEmployees(): List<EmployeeDto>

}