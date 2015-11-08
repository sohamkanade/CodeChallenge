package com.home.test;

import java.util.Locale;

public class ListCountry {

	public static void main(String[] args) {
		ListCountry obj = new ListCountry();
		obj.run();
	}

	public void run() {
		
		String[] locales = Locale.getISOCountries();
		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);
			System.out.println("Country Code = " + obj.getCountry() + ", Country Name = " + obj.getDisplayCountry() + ", Language Name = " + obj.getLanguage());
		}
		System.out.println("Done");

		Locale us = new Locale("", "uS");
		System.out.println("Country Code = " + us.getCountry() + ", Country Name = " + us.getDisplayCountry());

		Locale us1 = new Locale("en", "");
		System.out.println("Country Code = " + us1.getCountry() + ", Country Name = " + us1.getDisplayCountry());
		System.out.println(us1.equals(Locale.ENGLISH));
		
		Locale de = new Locale("de", "");
		System.out.println("Country Code = " + de.getCountry() + ", Country Name = " + de.getDisplayCountry());
		System.out.println(de.equals(Locale.GERMAN));

		Locale fr = new Locale("", "fr");
		System.out.println("Country Code = " + fr.getCountry() + ", Country Name = " + fr.getDisplayCountry());
	}
}
