package com.petstore.testbase;

import org.junit.BeforeClass;

import com.petstore.junit.POST.CreatePetTest;
import com.petstore.model.CreatePetBuilder;
import com.petstore.utils.Util;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;


public class TestBase {
	
	
	//public CreatePetTest createPet = new CreatePetTest();
	public ValidatableResponse response = null;
	public CreatePetBuilder petBuilder = new CreatePetBuilder();
	
	public static String CategoryName = "Big";
	public static String PetName = Util.RandomNameGenerator();
	public static String PetStatus = "Available";
	public static String RequestPayload = "";
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
	}
	
	public String GetPayloadforPetCreation(String CategoryName,String PetName,String PetStatus) {
		petBuilder.UpdateCategoryName(CategoryName);
		petBuilder.UpdatePetName(PetName);
		petBuilder.UpdatePetStatus(PetStatus);
		return petBuilder.CreatePetPayload();
	}
	
	
	
	public String GetPayloadforUpdatePetCreation(long id) {
		petBuilder.UpdateCategoryName(CategoryName+"_Updated");
		petBuilder.UpdatePetName(PetName+"_Updated");
		petBuilder.UpdatePetStatus(PetStatus);
		petBuilder.UpdatePetId(id);
		return petBuilder.CreatePetPayload();
	}

}
