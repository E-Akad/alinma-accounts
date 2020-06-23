package com.alinma.rib.accounts.service;

import com.alinma.rib.accounts.model.response.SendIbanResponse;

public interface ISendIbanService {

	SendIbanResponse sendIban(String accountIndex, String sharingMethod);

}
