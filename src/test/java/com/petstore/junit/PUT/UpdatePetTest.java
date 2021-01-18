package com.petstore.junit.PUT;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.petstore.cucumber.serenity.PetstoreSerenitySteps;
import com.petstore.junit.POST.CreatePetTest;
import com.petstore.model.CreatePetBuilder;
import com.petstore.testbase.TestBase;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@RunWith(SerenityRunner.class)
public class UpdatePetTest extends TestBase {

	
	@Steps
	PetstoreSerenitySteps steps;
	
	@WithTags({@WithTag("POSITIVE"),@WithTag("SANITY")})
	
	@Title("This test is to update the PET")
	@Test
	public void test001() {
		long id = steps.createPet(CategoryName, PetName, PetStatus).extract().path("id");

		RequestPayload = GetPayloadforUpdatePetCreation(id);
		
		response = SerenityRest.given().
				header("Content-Type","application/json").
				header("Authorization","special-key").
				body(RequestPayload).log().all().when().put("/pet").then();

		ValidatableResponse getResponse = steps.GetPetDetailsbyId(id);
		assertThat(getResponse.extract().path("name"), equalTo(response.extract().path("name")));	
		assertThat(getResponse.extract().path("category.name"), equalTo(response.extract().path("category.name")));
	}

}
