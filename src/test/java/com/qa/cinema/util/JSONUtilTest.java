package com.qa.cinema.util;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.google.gson.Gson;

public class JSONUtilTest {
	
	private Gson gson = new Gson();
	
	private JSONUtil jsonUtil = new JSONUtil();

	@Test
	public void test() {
		
	}
	
	@Test
	public void getListFromJSONTest(){
		ArrayList<Object> objects = new ArrayList<>();
		String objectsJSON = gson.toJson(objects);
		assertEquals(objects, jsonUtil.getListFromJSON(objectsJSON, Object.class));
	}

}
