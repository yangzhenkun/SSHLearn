package com.yasin.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSON;
import com.opensymphony.xwork2.ActionSupport;
import com.yasin.model.User;
import com.yasin.service.IUserService;
import com.yasin.utils.Utils;

public class UserAction extends ActionSupport implements ServletRequestAware{
	private String status;

	private HttpServletRequest request;
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String state) {
		this.status = state;
	}

	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String addOrUpdateUser(){
		String content;
		try {
			content = Utils.stream2String(request.getInputStream());
			System.out.println(content);
			User user = JSON.parseObject(content,User.class);
			System.out.println(user.getUid()+","+user.getPwd());
			if(userService.addOrUpdateUser(user)){
				status="0";
			}else{
				status="1";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status="0";
		}
		
		return SUCCESS;
	}

	public String login() throws IOException{
		String content = Utils.stream2String(request.getInputStream());
		System.out.println(content);
		User user = JSON.parseObject(content, User.class);
		if(userService.checkUser(user)!=null){
			status="0";
		}else{
			status="1";
		}
		
		return SUCCESS;
	}
	
	
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

}
