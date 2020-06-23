package com.alinma.rib.accounts.util;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author mkorkar
 */

public class GeneralUtil {

	/**
	 * 
	 * @param list
	 * @return boolean value
	 */
	public static <T> boolean isListValid(List<T> list) {
		if (list != null && !list.isEmpty())
			return true;
		else
			return false;
	}

	/**
	 * 
	 * @param <T>
	 * @param list
	 * @return String
	 */
	public static <T> String listToString(List<T> list) {
		if (list == null || list.isEmpty())
			return "";
		return list.stream().map(T::toString).collect(Collectors.joining(","));
	}

	/**
	 * 
	 * @param xc
	 * @return String
	 */
	public static String convertXmlGregorianToString(XMLGregorianCalendar xc) {
		GregorianCalendar gCalendar = xc.toGregorianCalendar();
		return xc.toGregorianCalendar().getTime().toString();
	}

	public static boolean isValidString(String value) {
		if (value != null && value.length() > 0)
			return true;
		else
			return false;
	}

	/**
	 * @author Omnya Alaa
	 * @since 5-1-2020
	 * @category to check on any response if it succeeded
	 * @param String
	 *           status code
	 * @return boolean
	 *
	 */
	public static boolean isSuccess(String statusCode) {
		try {
			if (statusCode.trim().equalsIgnoreCase("I000000")) {
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * This method masks the Card Number
	 * 
	 * @param cardNum
	 * @return
	 */
	public static String getMaskedCardNumber(String cardNum) {
		if (null != cardNum) {
			int len = cardNum.length();
			return "xxxx xxxx xxxx " + cardNum.substring(len - 4, len);
		} else {
			return "";
		}
	}

}
