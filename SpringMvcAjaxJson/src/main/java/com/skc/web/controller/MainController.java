package com.skc.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.skc.web.domain.Organization;

@Controller
public class MainController {

	List<Organization> organizations ;

	MainController() {
		organizations = new ArrayList<Organization>();

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getPages() {

		ModelAndView model = new ModelAndView("example");
		return model;

	}
	@RequestMapping(value="/organization",method=RequestMethod.POST,headers = {"Accept=application/json"},produces={MediaType.APPLICATION_JSON_VALUE},consumes={MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Organization> saveOrganization(@RequestBody Organization organization){
		organizations.add(organization);
		return organizations;
	}

}
