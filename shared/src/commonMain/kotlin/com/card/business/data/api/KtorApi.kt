package com.card.business.data.api

import com.card.business.data.dto.EmployeeDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.Url

class KtorApi(private val client: HttpClient) : Api {
    override suspend fun fetchEmployees(): List<EmployeeDto> {
        return client.get(Url("https://github.com/AlexDeko/BusinessCard-KMP/blob/master/employees.json")) {}.body()
    }
}