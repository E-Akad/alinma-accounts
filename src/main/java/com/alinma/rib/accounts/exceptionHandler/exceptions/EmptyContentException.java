/**
 * 
 */
package com.alinma.rib.accounts.exceptionHandler.exceptions;

/**
 * @author Omnya Alaa
 * @since 3-2-2020
 */
public class EmptyContentException extends Exception {

	private String statusCode;
	private String statusDesc;
	private String exceptionMessage;

	public EmptyContentException() {
		super();
	}

	public EmptyContentException(String statusCode) {
		super();
		this.statusCode = statusCode;
	}

	public EmptyContentException(String statusCode, String statusDesc) {
		super();
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
	}

	public EmptyContentException(String statusCode, String statusDesc, String exceptionMessage) {
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
