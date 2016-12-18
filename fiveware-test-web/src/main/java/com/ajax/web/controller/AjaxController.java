package com.ajax.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import org.internal.service.CreateUser;

import com.ajax.web.jsonview.Views;
import com.ajax.web.model.AjaxResponseBody;
import com.ajax.web.model.SearchCriteria;
import com.ajax.web.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class AjaxController {
	private static final Logger logger=LoggerFactory.getLogger(AjaxController.class);

	List<User> users;

	// @ResponseBody, not necessary, since class is annotated with @RestController
	// @RequestBody - Convert the json data into object (SearchCriteria) mapped by field name.
	// @JsonView(Views.Public.class) - Optional, limited the json data display to client.
	@JsonView(Views.Public.class)
	@RequestMapping(value = "/search/api/getSearchResult")
	public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {

		logger.debug("Search:"+search.getUsername()+" bike:"+search.getBike()+" houses:"+search.getHouses()+" option:"+search.getOption());

		CreateUser service = new CreateUser();
		String res= service.create(search.getUsername(),search.getBike(),search.getOption(),search.getHouses());
		
		AjaxResponseBody result = new AjaxResponseBody();

		if(res.equals("OK")){
			result.setCode(res);
			result.setMsg("User created in db.");
			users = new ArrayList<User>();

			User user1 = new User(search.getUsername(), search.getBike(), search.getHouses(), search.getOption());
			users.add(user1);
			result.setResult(users);
			
		}else {
			result.setCode(res);
			result.setMsg("Error when updating db!");
			
			
		}
		
		//AjaxResponseBody will be converted into json format and send back to client.
		return result;

	}



}
