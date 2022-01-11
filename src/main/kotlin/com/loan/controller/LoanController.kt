package com.loan.controller

import com.loan.controller.request.LoanRequest
import com.loan.controller.request.UpdateLoanRequest
import com.loan.dto.ListLoans
import com.loan.dto.LoanResponse
import com.loan.entity.Loan
import com.loan.service.LoanService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/loans")
class LoanController(
    private val loanService: LoanService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CacheEvict(value = ["loan"], allEntries = true)
    fun createLoan(@RequestBody request: LoanRequest): LoanResponse{
        return loanService.createLoan(request)
    }

    @GetMapping("/details/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findLoanById(@PathVariable id: Int): LoanResponse{
        return loanService.findLoanById(id)
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: Int): Loan {
        return loanService.findById(id)
    }

    @GetMapping("/code/{code}")
    @ResponseStatus(HttpStatus.OK)
    fun findByCode (@PathVariable code: String): LoanResponse {
        return loanService.findByCode(code)
    }

    @GetMapping
    @Cacheable("loans")
    fun listLoans(
        @PageableDefault(size = 4, sort = ["loanApplicationDate"], direction = Sort.Direction.DESC) pagination: Pageable
    ): Page<ListLoans>{
        return loanService.listLoans(pagination)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteLoanById(@PathVariable id: Int){
        loanService.deleteLoanById(id)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateLoanById(@PathVariable id: Int, @RequestBody loanUpdated: UpdateLoanRequest) {
        loanService.updateLoanById(id, loanUpdated)
    }

}