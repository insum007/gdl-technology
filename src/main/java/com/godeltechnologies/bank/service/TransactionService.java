package com.godeltechnologies.bank.service;

import com.godeltechnologies.bank.dto.TransactionRequestDTO;
import com.godeltechnologies.bank.entity.TransactionEntity;

public interface TransactionService {

	public TransactionEntity saveTranaction(TransactionRequestDTO request);

}
