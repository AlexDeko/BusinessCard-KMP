package ktor

import dto.EmployeeDto
import dto.EmployeeDtoWrapper
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.Url
import network.EmployeesApi

class EmployeesKtorApi(private val client: HttpClient) : EmployeesApi {
    private companion object {
        const val GET_EMPLOYEES_URL =
            "https://raw.githubusercontent.com/AlexDeko/BusinessCard-KMP/master/employees.json"
    }

    override suspend fun fetchEmployees(): List<EmployeeDto> {
        return client.get(Url(GET_EMPLOYEES_URL)) {}.body()
    }
}