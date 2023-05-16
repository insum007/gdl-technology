package com.godeltechnologies.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.godeltechnologies.bank.dto.TransactionRequestDTO;
import com.godeltechnologies.bank.entity.TransactionEntity;
import com.godeltechnologies.bank.exception.BusinessException;
import com.godeltechnologies.bank.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

/**
 * TransactionController
 * 
 * @author Musni
 *
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	/**
	 * This method for save transaction
	 * 
	 * @param TransactionRequestDTO
	 * @return ResponseEntity
	 * 
	 */
	@ResponseStatus(value = HttpStatus.OK)
	@PostMapping("/transaction")
	public TransactionEntity saveTranaction(@RequestBody TransactionRequestDTO request) throws BusinessException {
		if (request.getCurrency() != null && !request.getCurrency().isBlank() && request.getAmount() != null
				&& !request.getAmount().equals("") && request.getAccountId() != null && !request.equals(" ")) {
			log.info("Inside saveTranaction method of TransactionController");
			return  transactionService.saveTranaction(request);

		} else {
			throw new BusinessException(HttpStatus.BAD_REQUEST, "Please provide the required fields.");

		}
	}

}
