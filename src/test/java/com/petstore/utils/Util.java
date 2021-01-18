package com.petstore.utils;

import com.github.javafaker.Faker;

public class Util {
	static Faker faker = new Faker();
	
	public static String RandomNameGenerator() {
        return faker.name().firstName();		
	}

}
