package com.petstore.junit.GET;



import org.junit.Test;
import org.junit.runner.RunWith;

import com.petstore.cucumber.serenity.PetstoreSerenitySteps;
import com.petstore.junit.POST.CreatePetTest;
import com.petstore.testbase.TestBase;

import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


@RunWith(SerenityRunner.class)
public class GetPetByIdTest extends TestBase {

	@Steps
	PetstoreSerenitySteps steps;
	
	@WithTags({@WithTag("POSITIVE"),@WithTag("SANITY")})
	@Title("This test is GET pet by ID")
	@Test
	public void test001() {
		long id = steps.createPet(CategoryName, PetName, PetStatus).extract().path("id");
		response = steps.GetPetDetailsbyId(id);
		assertThat(response.extract().path("name"), is(PetName));	
	}
}
