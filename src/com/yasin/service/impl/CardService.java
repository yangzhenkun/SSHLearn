package com.yasin.service.impl;

import java.util.List;

import com.yasin.dao.ICardDAO;
import com.yasin.model.Card;
import com.yasin.service.ICardService;

public class CardService implements ICardService {

	private ICardDAO cardDAO;
	
	
	public ICardDAO getCardDAO() {
		return cardDAO;
	}


	public void setCardDAO(ICardDAO cardDAO) {
		this.cardDAO = cardDAO;
	}


	@Override
	public Integer addCard(Card card) {
		return cardDAO.addCard(card);
	}


	@Override
	public Boolean deleteCard(Card card) {
		return cardDAO.deleteCard(card);
	}


	@Override
	public Boolean updateCard(Card card) {
		return cardDAO.updateCard(card);
	}


	@Override
	public List getAllCard(String uid) {
		return cardDAO.getAllCard(uid);
	}

}
