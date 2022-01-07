package com.loan.mapper

import com.loan.dto.CustomerResponse
import com.loan.entity.Customer
import org.springframework.stereotype.Component

@Component
class CustomerResponseMapper: Mapper<Customer, CustomerResponse> {
    override fun map(c: Customer): CustomerResponse {
        return  CustomerResponse(
            id = c.id,
            name = c.name,
            email = c.email,
            password = c.password,
            birthDate = c.birthDate,
            cpf = c.cpf,
            rg = c.rg,
            phone = c.phone,
            monthlyIncome = c.monthlyIncome,
            address = c.address
        )
    }

}