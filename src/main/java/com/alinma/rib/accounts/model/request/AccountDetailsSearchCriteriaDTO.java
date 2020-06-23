/**
 * 
 */
package com.alinma.rib.accounts.model.request;

import java.io.Serializable;

import com.alinma.rib.models.system.request.StmtDtlsInq52000000.StmtDtlsInqRqBody;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author mkorkar
 *
 */
@Getter
@Setter
@ToString
public class AccountDetailsSearchCriteriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long accountNumber;
	private String fromDate;
	private String toDate;
	private String fromDateHijri;
	private String toDateHijri;
	private Boolean graph;
	private Integer maxRecords;
	private Integer offset;
	private String transactionRefNum;
	private String transactionType;
	private String fromAmount;
	private String toAmount;
	private String extension; 
	
}
