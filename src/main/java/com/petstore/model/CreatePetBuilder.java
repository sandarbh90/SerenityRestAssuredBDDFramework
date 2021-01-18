package com.petstore.model;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class CreatePetBuilder {
	
JSONObject jsonObject = null;
	
	public CreatePetBuilder(){
		JSONParser parser = new JSONParser();		
		try {
			Object obj = parser.parse(new FileReader("src/test/resources/testdata/CreatePetPayload.json"));
			jsonObject = (JSONObject) obj;
			//this.jsonObject = jsonObject;
		}
		catch(Exception e) {			
		}		
	}

	public void UpdateCategoryName(String CategoryName) {
		JSONObject category = (JSONObject) jsonObject.get("category");
		category.put("name", CategoryName);   
	}
	
	public void UpdatePetName(String PetName) {
		jsonObject.put("name", PetName);  
	}
	
	public void UpdatePetStatus(String Status) {
		jsonObject.put("status", Status);  
	}
	
	public void UpdatePetId(long id) {
		jsonObject.put("id", id);  
	}
	
	public String CreatePetPayload() {
		return jsonObject.toString();
	}
	
}
