package com.yasin.service;

import java.util.List;

import com.yasin.model.Card;

public interface ICardService {
	public Integer addCard(Card card);
	public Boolean deleteCard(Card card);
	public Boolean updateCard(Card card);
	public List getAllCard(String uid);
}
