package com.gnm.error;

public enum ErrorDetails {

	NULL_EMPTY_FOUND(1000, "Null/Empty value found"), UNABLE_TO_PUSH_TO_QUEUE(1001, "UNABLE TO PUSH MSG TO QUEUE"),
	UNABLE_TO_SEND_EMAIL(1002, "UNABLE TO SEND EMAIL");

	private final int code;
	private final String description;

	private ErrorDetails(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code + ": " + description;
	}

}