/**
 * 
 */
package com.alinma.rib.accounts.model.response;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Hani Younis
 *
 */
public enum TransactionType implements EntityKey{
	
	CREDIT("CR"),DEBIT("DR");
	private String code;
	private static Map<String, TransactionType> map;
	
	static {
		map = new HashMap<String, TransactionType>();
		for(TransactionType value: TransactionType.values()) {
			map.put(value.getCode(), value);
		}
	}
	
	TransactionType(String code){
		this.code=code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static TransactionType getByCode(String code) {
		if(map == null) {
			return null;
		}
		return map.get(code);
	}
}
