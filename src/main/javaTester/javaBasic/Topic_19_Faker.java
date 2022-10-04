package javaBasic;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakerIDN;

import java.util.Locale;

public class Topic_19_Faker {

	public static void main(String[] args) {
		Faker faker = new Faker();
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().lastName());
		System.out.println(faker.business().creditCardType());
		System.out.println(faker.business().creditCardNumber());
		System.out.println(faker.business().creditCardExpiry());
		System.out.println("-----------------------------------");
		Faker fakerVi = new Faker(new Locale("vi"));
		System.out.println(fakerVi.address().firstName());
		System.out.println(fakerVi.address().lastName());
		System.out.println(fakerVi.business().creditCardType());
	}

}
