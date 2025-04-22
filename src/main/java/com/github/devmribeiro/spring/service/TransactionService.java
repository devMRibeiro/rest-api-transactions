package com.github.devmribeiro.spring.service;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.springframework.stereotype.Service;

import com.github.devmribeiro.spring.model.Transaction;

@Service
public class TransactionService {

	private final Queue<Transaction> transactions = new ConcurrentLinkedDeque<Transaction>();

	public void addTransaction(Transaction transaction) {
		transactions.add(transaction);
	}

	public void clearTransactions() {
		transactions.clear();
	}

	public DoubleSummaryStatistics getSummaryStatistics() {
		return transactions.stream()
				.filter(t -> t.dateTime().isAfter(OffsetDateTime.now().minusSeconds(60))) // Lista apenas estatísticas de transações que forem maior do que 1 minuto.  
				.mapToDouble(Transaction::value)
				.summaryStatistics();
	}
}