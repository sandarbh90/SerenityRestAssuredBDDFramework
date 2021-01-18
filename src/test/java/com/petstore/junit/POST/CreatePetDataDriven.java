package com.petstore.junit.POST;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.petstore.cucumber.serenity.PetstoreSerenitySteps;
import com.petstore.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;

//@Concurrent
@UseTestDataFrom("testdata/csv/CreatePetTestData.csv")
@RunWith(SerenityParameterizedRunner.class)
public class CreatePetDataDriven extends TestBase{
private String petName;
private String categoryName;
private String status;

public String getName() {
	return petName;
}
public void setName(String petName) {
	this.petName = petName;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}

@Steps
PetstoreSerenitySteps steps;

@WithTag("POSITIVE")
@Title("This test is to create a pet in system with data driven feature of serenity")
@Test
public void CreatePet() {		
	steps.createPet(categoryName, petName, status).statusCode(200);
}

}
