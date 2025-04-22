package com.github.devmribeiro.spring.model;

import java.time.OffsetDateTime;

public record Transaction(double value, OffsetDateTime dateTime) { }