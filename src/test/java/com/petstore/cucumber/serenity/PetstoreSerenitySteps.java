package com.petstore.cucumber.serenity;

import com.petstore.model.CreatePetBuilder;
import com.petstore.testbase.TestBase;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PetstoreSerenitySteps extends TestBase{

	@Step
	public ValidatableResponse createPet(String CategoryName,String PetName, String PetStatus){
		
   String RequestPayload = GetPayloadforPetCreation(CategoryName,PetName,PetStatus);
	
	return	SerenityRest.given().
			header("Content-Type","application/json").
			header("Authorization","special-key").
			body(RequestPayload).log().all().when().post("/pet").then();
				
	}

	@Step
	public ValidatableResponse GetPetDetailsbyId(long id){
		
	return	SerenityRest.given().accept(ContentType.JSON).when().get("/pet/"+id).then();
				
	}

}
