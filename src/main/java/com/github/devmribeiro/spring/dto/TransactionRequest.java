package com.github.devmribeiro.spring.dto;

import java.time.OffsetDateTime;

import io.micrometer.common.lang.NonNull;

public record TransactionRequest (@NonNull double value, @NonNull OffsetDateTime dateTime) { }