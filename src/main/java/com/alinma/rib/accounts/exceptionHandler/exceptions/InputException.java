/**
 * 
 */
package com.alinma.rib.accounts.exceptionHandler.exceptions;

/**
 * @author Omnya Alaa
 * @since 2-1-2020
 */
public class InputException extends Exception {

	private String statusCode;
	private String statusDesc;
	private String exceptionMessage;

	public InputException() {
		super();
	}

	public InputException(String statusCode) {
		super();
		this.statusCode = statusCode;
	}

	public InputException(String statusCode, String statusDesc) {
		super();
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
	}

	public InputException(String statusCode, String statusDesc, String exceptionMessage) {
		super();
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
		this.exceptionMessage = exceptionMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
}
