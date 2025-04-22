package com.github.devmribeiro.spring.controller;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.devmribeiro.spring.dto.TransactionRequest;
import com.github.devmribeiro.spring.model.Transaction;
import com.github.devmribeiro.spring.service.TransactionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService service;

	@PostMapping
	public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request) {
		if (request.dateTime().isAfter(OffsetDateTime.now()) || request.value() <= 0)
			return ResponseEntity.unprocessableEntity().build();

		service.addTransaction(new Transaction(request.value(), request.dateTime()));

		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@DeleteMapping
	public ResponseEntity<Void> clearTransactions() {
		service.clearTransactions();
		return ResponseEntity.ok().build();
	}
}