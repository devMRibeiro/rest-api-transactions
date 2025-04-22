package com.github.devmribeiro.spring.dto;

import java.util.DoubleSummaryStatistics;

public record StatisticsResponse(
		long count,
		double sum,
		double avg,
		double min,
		double max) {

	public StatisticsResponse(DoubleSummaryStatistics stats) {
		this(
            stats.getCount(),
            stats.getSum(),
            stats.getAverage(),
            stats.getMin(),
            stats.getMax()
        );
	}
}