/**
 * 
 */
package com.alinma.rib.accounts.middleware;

import com.alinma.rib.models.system.common.MsgRqHdr;

/**
 * @author Omnya Alaa
 * @since 26-12-2019
 * This is a shared service responsible for creating ESB calls and mocks
 * 
 */
public interface IAlinmaAccountsMiddleware {

	
	/**
	 * @return the Response from ESB or from Mock if you are in Mock Mode
	 * @param Object rqType
	 * @param String functionID 
	 * @param String sendDestination
	 * @param String recieveDestination
	 * @param Class responseClass
	 * @param String mockFileName will be sent to create the mock if ESB failed in case of MOCK Mode only
	 * */
	 Object callESBAndGetResponse(Object rqType, String functionID, String sendDestination,
			String recieveDestination, String mockFileName, Class responseClass) throws Exception;
	 MsgRqHdr createRequestHeader(String funcId) ;
}
