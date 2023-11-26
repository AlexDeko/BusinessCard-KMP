package com.card.business

import card.business.EmployeeEntity
import com.card.business.data.dto.EmployeeDto
import com.card.business.domain.models.Employee
import com.card.business.domain.models.Job

fun EmployeeDto.mapToEmployeeEntity(): EmployeeEntity {
    return EmployeeEntity(
        id = id, last_name = lastName, first_name = firstName, job = job
    )
}


fun EmployeeEntity.mapToEmployee(): Employee {
    return Employee(
        id = id,
        firstName = first_name, lastName = last_name,
        job = Job.create(job)
    )
}