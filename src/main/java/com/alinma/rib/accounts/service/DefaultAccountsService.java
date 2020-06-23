package com.alinma.rib.accounts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.exceptionHandler.exceptions.ESBException;
import com.alinma.rib.accounts.exceptionHandler.exceptions.InputException;
import com.alinma.rib.accounts.model.request.DefaultAccountRequest;
import com.alinma.rib.accounts.model.response.DefaultAccountResponse;
import com.alinma.rib.accounts.model.response.DefaultAccountResponseDefaultAccountRs;
import com.alinma.rib.authentication.business.enums.StatusDesc;
import com.alinma.rib.models.system.common.AttribInfo;
import com.alinma.rib.models.system.common.AttribsList;
import com.alinma.rib.models.system.common.MsgRqHdr;
import com.alinma.rib.models.system.common.enums.ESBStatusCode;
import com.alinma.rib.models.system.common.enums.FuncIdEnum;
import com.alinma.rib.models.system.common.enums.MQReceiveDestination;
import com.alinma.rib.models.system.common.enums.MQSendDestination;
import com.alinma.rib.models.system.request.UsrMng55000030.UsrChanInfo;
import com.alinma.rib.models.system.request.UsrMng55000030.UsrMngRq;
import com.alinma.rib.models.system.request.UsrMng55000030.UsrMngRqBody;
import com.alinma.rib.models.system.response.UsrMng55000030.UsrMngRs;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;
import com.alinma.rib.service.user.UserService;


@Service
public class DefaultAccountsService {
	
	@Autowired
	MiddlewareCommunicator middlewareCommunicator;

	@Autowired
	UserService userService;

	@Autowired
	@Qualifier("errorMsg")
	MessageSource errorMessageSource;
	
	private static Logger logger = LoggerFactory.getLogger(DefaultAccountsService.class);

	
	public DefaultAccountResponse setDefaultAccount(DefaultAccountRequest defaultAccountRequest, String accountIndex) throws Exception {

		logger.info("in set default account with " + defaultAccountRequest.getDefaultAccountRq());

		if (accountIndex == null) {

			InputException inputEx = new InputException();
			inputEx.setExceptionMessage("accountIndex is empty");
			throw inputEx;
		}
		// request of ESB
		MsgRqHdr msgRqHdr = new MsgRqHdr();
		UsrMngRq usrMngRq = new UsrMngRq();
		UsrMngRqBody usrMngRqBody = new UsrMngRqBody();
		UsrChanInfo usrChanInfo = new UsrChanInfo();
		AttribsList attribsList = new AttribsList();
		List<AttribInfo> AttribInfoList = new ArrayList<AttribInfo>();
		AttribInfo attribInfo = new AttribInfo();

		// fill header
		msgRqHdr = middlewareCommunicator.createRequestHeader(FuncIdEnum.UPDATE_PREFERRED_AUTH_METHOD.getValue());

		// fill body
		usrChanInfo.setChanId("IB");
		usrChanInfo.setDfltChanUsrAcctNum(accountIndex);
		if (defaultAccountRequest.getDefaultAccountRq().isSetDefault() == true)
		{
			attribInfo.setName("DefaultAccount");
			attribInfo.setVal("");
		}

		AttribInfoList.add(attribInfo);
		attribsList.setAttribInfo(AttribInfoList);
		usrChanInfo.setAttribsList(attribsList);
		usrMngRqBody.setUsrId(userService.getUserId());
		usrMngRqBody.setUsrChanInfo(usrChanInfo);

		// fill request
		usrMngRq.setMsgRqHdr(msgRqHdr);
		usrMngRq.setBody(usrMngRqBody);

		// response of front end
		DefaultAccountResponse defaultAccountResponse = new DefaultAccountResponse();
		DefaultAccountResponseDefaultAccountRs defaultAccountRsBody = new DefaultAccountResponseDefaultAccountRs();

		// response of ESB
		UsrMngRs usrMngRs = new UsrMngRs();

		try {
			usrMngRs = (UsrMngRs) middlewareCommunicator.sendRequestAndRecieveResponse(usrMngRq, MQSendDestination.USR_MNG_RQ.getValue(), MQReceiveDestination.USR_MNG_RS.getValue(), UsrMngRs.class);
			if (usrMngRs != null) {
				defaultAccountRsBody.setStatusCode(usrMngRs.getMsgRsHdr().getStatusCode());
				if (usrMngRs.getMsgRsHdr().getStatusCode().equals(ESBStatusCode.SUCCESS.getValue())) {
					defaultAccountRsBody.setStatusDesc(StatusDesc.SUCCESS.toString());
				} else {
					defaultAccountRsBody.setStatusDesc(errorMessageSource.getMessage(usrMngRs.getMsgRsHdr().getStatusCode(), null, new Locale(userService.getCurLang())));
				}
			} else {
				logger.info("the esb response is empty");
				throw new ESBException("response is empty");
			}
		} catch (ESBException e) {
			e.printStackTrace();
			throw new ESBException();
		}
		defaultAccountResponse.setDefaultAccountRs(defaultAccountRsBody);
		return defaultAccountResponse;
	}
}
