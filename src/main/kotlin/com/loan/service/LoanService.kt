package com.loan.service

import com.loan.controller.request.LoanRequest
import com.loan.dto.ListLoans
import com.loan.dto.LoanResponse
import com.loan.exception.ValidationException
import com.loan.mapper.ListLoansMapper
import com.loan.mapper.LoanRequestMapper
import com.loan.mapper.LoanResponseMapper
import com.loan.repository.LoanRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.temporal.ChronoUnit


@Service
class LoanService(
    val loanRepository: LoanRepository,
    val loanRequestMapper: LoanRequestMapper,
    val loanResponseMapper: LoanResponseMapper,
    val listLoansMapper: ListLoansMapper,
    private val MAXIMUM_PARCELS: Int = 60,
private val MAXIMUM_DATE:Int = 90
) {
    fun createLoan(request: LoanRequest): LoanResponse {
        validateLoanApplication(request)
        val customerMapper = loanRequestMapper.map(request)
        loanRepository.save(customerMapper)
        return loanResponseMapper.map(customerMapper)
    }

    fun findLoanById(id: Long): LoanResponse {
        val loan = loanRepository.findById(id)
            .orElseThrow{ValidationException("ID não encontrado.")}
        return loanResponseMapper.map(loan)
    }

//    fun findLoanByCode(codeLoan: Long): LoanResponse {
//        if (codeLoan == null){
//            throw ValidationException("O código do empréstimo precisa ser informado.")
//        }
//        val loan = loanRepository.findByCodeLoan(codeLoan)
//        return loanResponseMapper.map(loan)
//    }

    fun listLoans(code: String?, pagination: Pageable): Page<ListLoans> {
        val loans = if(code == null){
            loanRepository.findAll(pagination)
        } else {
            loanRepository.findByCode(code, pagination)
        }
        return loans.map{ l ->
            listLoansMapper.map(l)
        }
    }

    private fun validateLoanApplication(request: LoanRequest){
        if(request.parcel > MAXIMUM_PARCELS){
            throw ValidationException("O número máximo de parcelas é 60.")
        }

        val firstParcelDate: LocalDate = request.firstParcelDate
        val curranteDate = LocalDate.now()
        val range = ChronoUnit.DAYS.between(curranteDate, firstParcelDate)
        println(range)

        if (range > MAXIMUM_DATE) {
            throw ValidationException("A data limite para pagamento da primeira parcela é: " + curranteDate.plusDays(90))
        }
    }

}
