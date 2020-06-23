package com.alinma.rib.accounts.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountTransfereDTO {
private static final long serialVersionUID = 1L;
	
	private Long accountIndex;
	private String fromDate;
	private String toDate;
	private Integer maxRecords;
	private Integer offset;
	private String transactionRefNum;
	private Double fromAmount;
	private Double toAmount;
}
