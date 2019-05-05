package com.gnm.response;

import com.gnm.error.ErrorDetails;

public class MessageResponse {

	private boolean success;

	private ErrorDetails errorCode;

	private String errorMessage;

	/**
	 * 
	 */
	public MessageResponse() {
		super();

	}

	/**
	 * @param success
	 * @param errorCode
	 * @param errorMessage
	 */
	public MessageResponse(Boolean success, ErrorDetails errorCode, String errorMessage) {
		super();
		this.success = success;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public MessageResponse(boolean success) {
		this.success = success;
	}

	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}

	/**
	 * @return the errorCode
	 */
	public ErrorDetails getErrorCode() {
		return errorCode;
	}

	/**
	 * @param nullEmptyFound the errorCode to set
	 */
	public void setErrorCode(ErrorDetails nullEmptyFound) {
		this.errorCode = nullEmptyFound;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
