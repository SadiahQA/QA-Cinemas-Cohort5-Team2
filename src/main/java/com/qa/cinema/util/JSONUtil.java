package com.qa.cinema.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qa.cinema.persistence.Ticket;

public class JSONUtil {

	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> clazz) {
		return gson.fromJson(jsonString, clazz);
	}
	

	public <T> List<T> getListFromJSON(String tickets, Class<T> clazz){
		Type type = new TypeToken<List<T>>(){}.getType();
	    List<T> ticketList = new Gson().fromJson(tickets, type);
		List<T> newTickets = new ArrayList<>();
	    for (T t: ticketList) {
	    	newTickets.add(t);
	    }
	    return newTickets;
	}

}
