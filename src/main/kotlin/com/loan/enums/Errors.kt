package com.loan.enums

enum class Errors(
    val code: String,
    val message: String
) {

    ML000("ERROR-403", "Unauthorized"),
    ML001("ERROR-400", "Invalid Request"),
    ML003("ERROR-403", "Access Denied")
}