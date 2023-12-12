package mapping

import card.business.EmployeeEntity
import dto.EmployeeDto
import models.Employee
import models.Job

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