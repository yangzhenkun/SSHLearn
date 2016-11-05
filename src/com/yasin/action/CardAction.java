package com.yasin.action;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.yasin.dao.impl.CardDAO;
import com.yasin.model.Card;
import com.yasin.model.User;
import com.yasin.service.ICardService;
import com.yasin.utils.Utils;

public class CardAction extends ActionSupport implements ServletRequestAware{
	private ICardService cardService;
	
	private String status,cardid,allcard;
	private HttpServletRequest request;

	public String getAllcard() {
		return allcard;
	}

	public void setAllcard(String allcard) {
		this.allcard = allcard;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cid) {
		this.cardid = cid;
	}

	public ICardService getCardService() {
		return cardService;
	}

	public void setCardService(ICardService cardService) {
		this.cardService = cardService;
	}

	
	public String addCard(){
		
		try {
			String content = Utils.stream2String(request.getInputStream());
			System.out.println(content);
			JSONObject json = JSON.parseObject(content);
			User user = new User();
			user.setUid(json.getString("uid"));
			Card card = new Card();
			card.setUser(user);
			card.setCinfo(json.getString("cinfo"));
			Integer temp = cardService.addCard(card);
			if(temp==null){
				status="1";
				cardid="null";
			}else{
				status="0";
				cardid=""+temp;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			status="1";
			cardid="null";
		}
		
		return SUCCESS;
	}
	
	public String deleteCard(){
		try {
			String content = Utils.stream2String(request.getInputStream());
			JSONObject json = JSON.parseObject(content);
			User user = new User();
			user.setUid(json.getString("uid"));
			Card card = new Card();
			card.setCid(json.getInteger("cid"));
			card.setUser(user);
			if(cardService.deleteCard(card)){
				status="0";
			}else{
				status="1";
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			status="1";
		}
		
		
		
		return SUCCESS;
	}
	
	public String updateCard(){
		try {
			String content = Utils.stream2String(request.getInputStream());
			System.out.println(content);
			JSONObject json = JSON.parseObject(content);
			User user = new User();
			user.setUid(json.getString("uid"));
			Card card = new Card();
			card.setCid(json.getInteger("cid"));
			card.setCinfo(json.getString("cinfo"));
			card.setUser(user);
			if(cardService.updateCard(card)){
				status="0";
			}else{
				status="1";
			}
			
		} catch (IOException e) {
			status = "1";
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String getAllCard(){
		try {
			String content = Utils.stream2String(request.getInputStream());
			System.out.println(content);
			JSONObject json = JSON.parseObject(content);
			String uid = json.getString("uid");
			List list = cardService.getAllCard(uid);
			System.out.println(list.size());
			JSONArray jsonA = new JSONArray();
			for(int i=0;i<list.size();i++){
				Card card = (Card) list.get(i);
				JSONObject jsonT = new JSONObject();
				jsonT.put("inf", card.getCinfo());
				jsonT.put("cid", card.getCid());
				jsonA.add(jsonT);
			}
			allcard=jsonA.toString();
			System.out.println(allcard);
			status="0";
		} catch (IOException e) {
			e.printStackTrace();
			status="1";
			allcard="null";
		}
		return SUCCESS;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	
}
