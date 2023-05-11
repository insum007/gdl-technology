package com.godeltechnologies.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.godeltechnologies.bank.dto.TransactionRequestDTO;
import com.godeltechnologies.bank.entity.Status;
import com.godeltechnologies.bank.entity.TransactionEntity;
import com.godeltechnologies.bank.repository.TransactionRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * TransactionService
 * 
 * @author Musni
 *
 */
@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public TransactionEntity saveTranaction(TransactionRequestDTO request) {
		log.info("Inside saveTranaction method of TransactionService");
		TransactionEntity transaction = TransactionEntity.builder().amount(request.getAmount())
				.currency(request.getCurrency()).accountId(request.getAccountId()).status(Status.NEW).build();

		return transactionRepository.save(transaction);

	}

}
