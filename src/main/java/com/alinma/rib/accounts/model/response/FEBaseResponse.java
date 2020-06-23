/**
 * 
 */
package com.alinma.rib.accounts.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Omnya Alaa
 * @since 30-12-2019
 *
 */
public class FEBaseResponse {

	@JsonProperty("statusCode")
	private String statusCode = null;

	@JsonProperty("statusDesc")
	private String statusDesc = null;

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

}
