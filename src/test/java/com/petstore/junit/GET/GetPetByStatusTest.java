package com.petstore.junit.GET;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.petstore.junit.POST.CreatePetTest;

import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;

@RunWith(SerenityRunner.class)
public class GetPetByStatusTest {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
	}
	
	@WithTag("POSITIVE")
	@Title("Test to get all the pet by status")
	@Test
	public void getPetbyStatus() {
				
		SerenityRest
		.given()
		.header("Content-Type", "application/json")
		.header("Authorization","special-key")
		.param("status", "sold")
		.when()
		.get("/pet/findByStatus")
		.then()
		.log()
		.all()
		.statusCode(200);		
	}
	
	@WithTag("NEGATIVE")
	@Title("Test to verify failing scenario")
	@Test
	public void getPetbyStatusFailing() {
		SerenityRest
		.given()
		.header("Content-Type", "application/json")
		.header("Authorization","special-key")
		.param("status", "sold")
		.when()
		.get("/pet/findByStatus")
		.then()
		.log()
		.all()
		.statusCode(500);		
	}
	
	@WithTag("NEGATIVE")
	@Title("Test to verify pending scenario")
	@Test
	@Pending
	public void getPetbyStatusPending() {
				
	}
	
	@WithTag("NEGATIVE")
	@Title("Test to verify ignore scenario")
	@Test
	@Ignore
	public void getPetbyStatusIgnore() {
				
	}
	
	@WithTag("NEGATIVE")
	@Title("Test to verify error scenario")
	@Test
	public void getPetbyStatusError() {
		System.out.println("Divide by zero"+(5/0));
				
	}
	
	@WithTag("NEGATIVE")
	@Title("Test to verify manual scenario")
	@Test
	@Manual
	public void getPetbyStatusManual() {
				
	}
	
	@WithTag("NEGATIVE")
	@Title("Test to verify compromised scenario")
	@Test
	public void getPetbyStatusCompromised() throws FileNotFoundException {
		File f = new File("C://a.txt");
		FileReader fr = new FileReader(f);				
	}
	

}
