package com.alinma.rib.accounts.model;

/**
 * @author 
 * 
 */
public class CardFeeFieldDialog  {

	
	private String labelEnglish;
	private String labelArabic;
	private String valueEnglish;
	private String valueArabic;
	private int orderFee;
	
	
	public String getLabel() {
		return labelEnglish;	
//		if(FacesContext.getCurrentInstance().getViewRoot().getLocale().equals(Locale.ENGLISH)) {
//		}else {
//			return labelArabic;
//		}
	}
	
	public void setLabelEnglish(String labelEnglish) {
		this.labelEnglish = labelEnglish;
	}
	
	public void setLabelArabic(String labelArabic) {
		this.labelArabic = labelArabic;
	}
	public String getValue() {
		return valueEnglish;	
//		if(FacesContext.getCurrentInstance().getViewRoot().getLocale().equals(Locale.ENGLISH)) {
//		}else {
//			return valueArabic;
//		}
		
	}
	
	public String getLabelEnglish() {
		return labelEnglish;
	}

	public String getLabelArabic() {
		return labelArabic;
	}

	public String getValueEnglish() {
		return valueEnglish;
	}

	public String getValueArabic() {
		return valueArabic;
	}

	public void setValueEnglish(String valueEnglish) {
		this.valueEnglish = valueEnglish;
	}

	public void setValueArabic(String valueArabic) {
		this.valueArabic = valueArabic;
	}

	public int getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(int orderFee) {
		this.orderFee = orderFee;
	}
	

}
