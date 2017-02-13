package com.xad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * select name from Country where name = 'united states' union all SELECT * from (select name FROM country where name != 'united states' order by name) b;
 * 
 * @author spark
 *
 */
public class SortCountry {

	public class Country {
		String name;
		public Country(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}

	public List<Country> getCountries() {
		Country france = new Country("france");
		Country china = new Country("china");
		Country ghana = new Country("ghana");
		Country zimbabwe = new Country("zimbabwe");
		Country unitedStates = new Country("united states");
		List<Country> countries = new ArrayList<>();
		countries.add(france);
		countries.add(china);
		countries.add(ghana);
		countries.add(zimbabwe);
		countries.add(unitedStates);
		return countries;
	}

	public void sortCountries(List<Country> countries) {
		countries.stream().sorted((c1, c2) ->{
			if(c1.getName().equals("united states")) {
				return -1;
			} else if(c2.getName().equals("united states")) {
				return 1;
			} 
			return c1.getName().compareTo(c2.getName());
		}).map(Country::getName).forEach(System.out::println);
	}

	public void sortCountriesOld(List<Country> countries) {
		Comparator<Country> comp = new Comparator<Country>() {
			@Override
			public int compare(Country c1, Country c2) {
				if(c1.getName().equals("united states")) {
					return -1;
				} else if(c2.getName().equals("united states")) {
					return 1;
				} 
				return c1.getName().compareTo(c2.getName());
			}
		};
		Collections.sort(countries, comp);
		for(Country country: countries) {
			System.out.println(country.getName());
		}
	}
	
	public class CountryComparator implements Comparator<Country> {

		@Override
		public int compare(Country c1, Country c2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

	public static void main(String[] args) {
		System.out.println("\n<new way>");
		SortCountry sc = new SortCountry();
		sc.sortCountries(sc.getCountries());
		System.out.println("\n<old way>");
		sc.sortCountriesOld(sc.getCountries());
	}
}

/*
 Sort anagram groups according to size
Collections.sort(winners, new Comparator<List<String>>() {
    public int compare(List<String> o1, List<String> o2) {
        return o2.size() - o1.size();
    }});
*/
