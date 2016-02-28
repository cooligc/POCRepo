package com.skc.poc.struts.actions.search;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> searchEngines;
	private String query;
	private String yourSearchEngine;
	private String defaultSearchEngine;
	
	public List<String> getSearchEngines() {
		return searchEngines;
	}
	public void setSearchEngines(List<String> searchEngines) {
		this.searchEngines = searchEngines;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	
	public SearchAction(){
		System.out.println("============================> Constructor <==============================");
		searchEngines = new ArrayList<String>();
		searchEngines.add("google");
		searchEngines.add("yahoo");
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("============================> Executed <==============================");
		return "SUCCESS";
	}
	
	public String display(){
		System.out.println("============================> display <==============================");
		return "NONE";
	}
	public String getYourSearchEngine() {
		return yourSearchEngine;
	}
	public void setYourSearchEngine(String yourSearchEngine) {
		this.yourSearchEngine = yourSearchEngine;
	}
	public String getDefaultSearchEngine() {
		return searchEngines.get(0);
	}
	
}
