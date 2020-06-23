package com.alinma.rib.accounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alinma.rib.accounts.model.response.CardsLightInquiryResponse;
import com.alinma.rib.accounts.service.ViewActiveCreditCardListService;
import com.alinma.rib.models.business.exception.CustomServiceUnavailableException;

@RestController
@RequestMapping(value = "/v1")
public class ViewActiveCreditCardListController {

	@Autowired
	ViewActiveCreditCardListService activeCreditCardListService; 

	@GetMapping("/cards")
	public CardsLightInquiryResponse getCardsLightInquiry() throws CustomServiceUnavailableException{
		return activeCreditCardListService.getCardsLightInquiry();
	}

}
