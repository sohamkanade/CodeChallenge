package com.xad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Sort City by Country Name and City Name
public class SortCity {

	public class Country {
		private Long id;
		private String name;
		Set<City> cities = new HashSet<>();

		public Country() {}
		
		public Country(String name) {
			this.name = name;
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public Set<City> getCities() {
			return cities;
		}
	}

	public class City {
		Long id;
		String name;
		Country country;

		public City() {}

		public City(String name, Country country) {
			this.name = name;
			this.country = country;
			this.country.getCities().add(this);
		}

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Country getCountry() {
			return country;
		}
		public void setCountry(Country country) {
			this.country = country;
			this.country.getCities().add(this);
		}
	}

	public List<City> getCities() {
		Country france = new Country("france");
		Country china = new Country("china");
		Country ghana = new Country("ghana");
		Country zimbabwe = new Country("zimbabwe");
		Country unitedStates = new Country("united states");
		
		City paris = new City("paris", france);
		City mutare = new City("mutare", zimbabwe);
		City beijing = new City("beijing", china);
		City lyon = new City("lyon", france);
		City accra = new City("accra", ghana);
		City sanghai = new City("sanghai", china);
		City harare = new City("harare", zimbabwe);
		City washingtonDC = new City("washington dc", unitedStates);
		City chicago = new City("chicago", unitedStates);
		City michgan = new City("michigan", unitedStates);

		List<City> cities = new ArrayList<>();
		cities.add(harare);
		cities.add(beijing);
		cities.add(mutare);
		cities.add(michgan);
		cities.add(chicago);
		cities.add(washingtonDC);
		cities.add(sanghai);
		cities.add(accra);
		cities.add(lyon);
		cities.add(paris);
		
		/*
+----+---------------+
| Id | name          |
+----+---------------+
| 1  | france        |
| 2  | china         |
| 3  | ghana         |
| 4  | zimbabwe      |
| 5  | united states |
+----+---------------+

+----+---------------+---------------+
| Id | name          | country_id    |
+----+---------------+---------------+
| 1  | paris         | 1             |
| 2  | mutare        | 4             |
| 3  | beijing       | 2             |
| 4  | lyon          | 1             |
| 5  | accra         | 3             |
| 6  | sanghai       | 2             |
| 7  | harare        | 4             |
| 8  | washington dc | 5             |
| 9  | chicago       | 5             |
| 10 | michigan      | 5             |
+----+---------------+---------------+

select * from(select City.NAME from City JOIN COUNTRY ON city.COUNTRY_ID = country.ID where country.NAME = 'united states' order by city.NAME) a union all select * from (select City.NAME from City JOIN COUNTRY ON city.COUNTRY_ID = country.ID where country.NAME != 'united states' order by country.name, city.name) b;

NAME
chicago
michigan
washington dc
beijing
sanghai
lyon
paris
accra
harare
mutare
		 */
		return cities;
	}

	public void sortCities(List<City> cities) {
		cities.stream().sorted((c1, c2) ->{
			if(!c1.getCountry().getName().equals(c2.getCountry().getName())) {
				if(c1.getCountry().getName().equals("united states")) {
					return -1;
				} else if(c2.getCountry().getName().equals("united states")) {
					return 1;
				} else {
					return c1.getCountry().getName().compareTo(c2.getCountry().getName());
				}
			}
			return c1.getName().compareTo(c2.getName());
		}).map(City::getName).forEach(System.out::println);
	}

	public void sortCitiesOld(List<City> cities) {
		Comparator<City> comp = new Comparator<City>() {
			@Override
			public int compare(City c1, City c2) {
				if(!c1.getCountry().getName().equals(c2.getCountry().getName())) {
					if(c1.getCountry().getName().equals("united states")) {
						return -1;
					} else if(c2.getCountry().getName().equals("united states")) {
						return 1;
					} else {
						return c1.getCountry().getName().compareTo(c2.getCountry().getName());
					}
				}
				return c1.getName().compareTo(c2.getName());
			}
		};
		Collections.sort(cities, comp);
		for(City city: cities) {
			System.out.println(city.getName());
		}
	}

	public static void main(String[] args) {
		SortCity sc = new SortCity();
		sc.sortCities(sc.getCities());
		System.out.println("------------------");
		sc.sortCitiesOld(sc.getCities());
	}
}
