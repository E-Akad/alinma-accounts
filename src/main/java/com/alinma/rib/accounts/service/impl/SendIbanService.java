package com.alinma.rib.accounts.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.model.response.SendIbanResponse;
import com.alinma.rib.accounts.service.ISendIbanService;

/**
 * 
 * This service is called for sending IBAN via SMS or Mobile Wallet.
 * 
 * @author habdelhalim
 *
 */
@Service
public class SendIbanService implements ISendIbanService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SendIbanService.class);

	/**
	 * 
	 * This method sends IBAN via SMS or Mobile Wallet for a specific account based on sharingMethod.
	 * 
	 * @param accountIndex
	 * @param sharingMethod
	 * @return
	 */
	@Override
	public SendIbanResponse sendIban(String accountIndex, String sharingMethod) {
		
		return null;
	}
}
