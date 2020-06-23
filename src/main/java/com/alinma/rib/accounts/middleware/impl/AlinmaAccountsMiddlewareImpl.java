/**
 * 
 */
package com.alinma.rib.accounts.middleware.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.middleware.IAlinmaAccountsMiddleware;
import com.alinma.rib.models.system.common.MsgRqHdr;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;

/**
 * @author Omnya Alaa
 * @since 26-12-2019 This service implementation will be called normally without
 *        Mock Mode
 */
@Service
@Profile("!mock")
public class AlinmaAccountsMiddlewareImpl implements IAlinmaAccountsMiddleware {

	@Autowired
	MiddlewareCommunicator middlewareCommunicator;

	private static Logger logger = LoggerFactory.getLogger(AlinmaAccountsMiddlewareImpl.class);

	@Override
	public Object callESBAndGetResponse(Object rqType, String functionID, String sendDestination,
			String recieveDestination, String mockFileName, Class responseClass) throws Exception {
		try {
			logger.info("--------Alinma accounts Middleware and starts ESB CALL-----");
			Object response = middlewareCommunicator.sendRequestAndRecieveResponse(rqType, sendDestination,
					recieveDestination, responseClass);
			logger.info("--------Alinma accounts Middleware and ends ESB CALL with response : -----" + response);
			return response;
		} catch (Exception ex) {
			logger.error("--------Alinma accounts Middleware ends ESB CALL with failure" + ex.toString());
			throw ex;
		}
	}

	@Override
	public MsgRqHdr createRequestHeader(String funcId) {
	
		return middlewareCommunicator.createRequestHeader(funcId);
	}
}
