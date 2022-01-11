package com.loan.mapper

import com.loan.controller.request.CustomerRequest
import com.loan.entity.Customer
import com.loan.enums.StatusLoan
import org.springframework.stereotype.Component

@Component
class CustomerRequestMapper: Mapper<CustomerRequest, Customer> {
    override fun map(c: CustomerRequest): Customer {
        return  Customer(
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