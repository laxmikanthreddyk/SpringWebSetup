package com.cognizant.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.spring.web.dao.Offer;
import com.cognizant.spring.web.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	private OffersDAO offersDAO;
	
	public OffersService()
	{
		
	}
	
	@Autowired
	public void setOffersDAO(OffersDAO offersDAO) {
		this.offersDAO = offersDAO;
	}
	
	public List<Offer> getCurrentOffers()
	{
		return offersDAO.getOffers();
	}

	public void createOffer(Offer offer) {
		offersDAO.createOffer(offer);
	}

	public void throwDataException() {
		
		offersDAO.getOffer(9);
	}

}
