/**
 * 
 */
package com.alinma.rib.accounts.middleware.impl;

import java.io.File;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import com.alinma.rib.accounts.middleware.IAlinmaAccountsMiddleware;
import com.alinma.rib.models.system.common.MsgRqHdr;
import com.alinma.rib.service.middleware.MiddlewareCommunicator;

/**
 * @author Omnya Alaa
 * @since 26-12-2019
 * This service implementation will be called in Mock Mode only
 */
@Service
@Profile("mock")
public class AlinmaAccountsMiddlewareMockImpl implements IAlinmaAccountsMiddleware {

	private static Logger logger = LoggerFactory.getLogger(AlinmaAccountsMiddlewareMockImpl.class);

	@Autowired
	MiddlewareCommunicator middlewareCommunicator;

	
	/**
	 * @return the Response from Mock if you are in Mock Mode
	 * @param Object rqType
	 * @param String functionID 
	 * @param String sendDestination
	 * @param String recieveDestination
	 * @param Class responseClass
	 * @param String mockFileName will be sent to create the mock if ESB failed in case of MOCK Mode only
	 * */
	@Override
	public Object callESBAndGetResponse(Object benMngRqType, String functionID, String sendDestination, String recieveDestination, String mockFileName, Class responseClass) throws Exception {
		Object response = new Object();
		
			
			try {
				response = createMock(mockFileName, responseClass);

			} catch (Exception ex) {
				logger.error("----------Error in creating the mock due to : ---------" + ex.toString());
				response = createMock(mockFileName, responseClass);
				
			}
			logger.info("--------Alinma accounts Middleware -- response is -----" + response);
		
		return response;
	}
	
	public Object createMock(String fileName, Class responseClass) throws IOException, JAXBException {
		Object response = new Object();
		//Resource resource = new ClassPathResource("response/BenMngRs.xml");
		Resource resource = new ClassPathResource(fileName);
		File xmlFile;
		try {
			xmlFile = resource.getFile();
			JAXBContext jaxbContext = JAXBContext.newInstance(responseClass);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			response =  jaxbUnmarshaller.unmarshal(xmlFile);
			return response;
		} catch (IOException e) {
			logger.error("--------error in reading the xml response file may be you forgot to create it--------");
			throw e;
		} catch (JAXBException e) {
			logger.error("--------error in parsing the xml response file make sure of file structure--------");
			throw e;
		}
		

	}

	@Override
	public MsgRqHdr createRequestHeader(String funcId) {
		return middlewareCommunicator.createRequestHeader(funcId);
	}

	

}
