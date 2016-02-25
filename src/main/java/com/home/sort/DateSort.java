package com.home.sort;

import static java.util.Comparator.comparing;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

public class DateSort {

	public class Item {
		private Date date;
		private String number;
		private BigDecimal value;
		public Item(BigDecimal value, Date date, String number) {
			this.value = value;
			this.date = date;
			this.number = number;
		}
		public BigDecimal getValue() {
			return value;
		}
		public Date getDate() {
			return date;
		}
		public String getNumber() {
			return number;
		}
	}
	private List<Item> items = new ArrayList<>();

	public void prepare() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Item item1 = new Item(BigDecimal.valueOf(10.0d), sdf.parse("2015-06-23"), "20");
		Item item2 = new Item(BigDecimal.valueOf(5.0d), sdf.parse("2015-07-02"), "100");
		Item item3 = new Item(BigDecimal.valueOf(8.0d), sdf.parse("2015-05-09"), "");
		Item item4 = new Item(BigDecimal.valueOf(13.0d), sdf.parse("2015-08-20"), "01");
		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);
	}

	public void sort() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// this sorted ascending order
		System.out.println("[ ascending order ]");
		items.stream().sorted(comparing(Item::getDate)).forEach(item->{
			System.out.println(sdf.format(item.getDate()));
		});

		// reverse order
		System.out.println("\n[ descending order ]");
		items.stream().sorted(comparing(Item::getDate).reversed()).forEach(item->{
			System.out.println(sdf.format(item.getDate()));
		});

		System.out.println("\n[ order by number ]");
		items.stream().sorted((item1, item2) -> 
			Integer.compare(Integer.valueOf(StringUtils.isEmpty(item2.getNumber()) ? "0": item2.getNumber()), 
							Integer.valueOf(StringUtils.isEmpty(item1.getNumber()) ? "0": item1.getNumber()) )
		).forEach(item -> {
			System.out.println(item.getNumber());
		});
		// calculate
		System.out.println("\n[ last two calculation ]");
		Optional<BigDecimal> result = items.stream().sorted(comparing(Item::getDate).reversed()).limit(2).map(Item::getValue).reduce((val1, val2)->val1.subtract(val2));
		result.ifPresent( val -> System.out.println(val.toPlainString()));
	}

	public static void main(String[] args) {
		DateSort ds = new DateSort();
		try {
			ds.prepare();
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		ds.sort();
	}
}
