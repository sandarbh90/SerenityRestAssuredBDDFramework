package com.petstore.junit.POST;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.petstore.cucumber.serenity.PetstoreSerenitySteps;
import com.petstore.model.CreatePetBuilder;
import com.petstore.testbase.TestBase;
import com.petstore.utils.Util;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

import static org.assertj.core.api.Assertions.*;

@RunWith(SerenityRunner.class)
public class CreatePetTest extends TestBase{
	
	@Steps
	PetstoreSerenitySteps steps;
	
	@WithTags({@WithTag("POSITIVE")})
	@Title("This test is to create a pet in system")
	@Test
	public void CreatePet() {		
		steps.createPet(CategoryName, PetName, PetStatus).statusCode(200);
	}
}
