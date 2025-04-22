package com.github.devmribeiro.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.devmribeiro.spring.dto.StatisticsResponse;
import com.github.devmribeiro.spring.service.TransactionService;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	private TransactionService service;

	@GetMapping
	public ResponseEntity<StatisticsResponse> getStatistics() {
		return ResponseEntity.ok(new StatisticsResponse(service.getSummaryStatistics()));
	}
}