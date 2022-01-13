package com.dev.rev.prova.Exceptions;

import java.io.Serializable;

import lombok.Data;

@Data
public class ErrorDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	private String error;
	private String code;
	private String currentDate;

	public ErrorDetails() {
		super();
	}

	public ErrorDetails(String error, String code, String currentDate) {
		this.error = error;
		this.code = code;
		this.currentDate = currentDate;
	}
}