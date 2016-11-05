package com.yasin.dao;

import java.util.List;

import com.yasin.model.Card;

public interface ICardDAO {
	public Integer addCard(Card card);
	public Boolean deleteCard(Card card);
	public Boolean updateCard(Card card);
	public List getAllCard(String uid);
}
