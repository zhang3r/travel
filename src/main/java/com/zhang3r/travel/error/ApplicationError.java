package com.zhang3r.travel.error;

public class ApplicationError extends Error {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public ApplicationError(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
