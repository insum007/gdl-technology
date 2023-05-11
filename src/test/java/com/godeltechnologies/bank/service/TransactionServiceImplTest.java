package com.godeltechnologies.bank.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.godeltechnologies.bank.dto.TransactionRequestDTO;
import com.godeltechnologies.bank.entity.Status;
import com.godeltechnologies.bank.entity.TransactionEntity;
import com.godeltechnologies.bank.repository.TransactionRepository;

@SpringBootTest
public class TransactionServiceImplTest {

	@InjectMocks
	TransactionServiceImpl transactionServiceImpl;

	@Mock
	TransactionRepository transactionRepo;

	@Test
	public void saveTranactionTest() {

		TransactionRequestDTO request = TransactionRequestDTO.builder().currency("USD").amount(1000L).accountId(11111L)
				.build();

		TransactionEntity transaction = TransactionEntity.builder().currency(request.getCurrency())
				.amount(request.getAmount()).accountId(request.getAccountId()).status(Status.NEW).build();

		when(transactionRepo.save(transaction)).thenReturn(createMockTransaction());

		TransactionEntity testedTransaction = transactionServiceImpl.saveTranaction(request);
		assertEquals(testedTransaction, transaction);

	}

	private TransactionEntity createMockTransaction() {

		TransactionEntity mockObject = TransactionEntity.builder().currency("USD").amount(1000L).accountId(11111L)
				.status(Status.NEW).build();

		return mockObject;

	}

}
