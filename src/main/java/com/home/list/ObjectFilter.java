package com.home.list;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class ObjectFilter {

	public String getValidUrl(List<Result> results) {
		return results.stream().filter(result -> StringUtils.isNotEmpty(result.getUrl())).map(Result::getUrl).findFirst().orElse("");
	}

	public static void main(String[] args) {
		List<Result> results = new ArrayList<>();
		ObjectFilter of = new ObjectFilter();
		System.out.println("No data: ".concat(of.getValidUrl(results)));

		Result result1 = new Result("", "info");
		results.add(result1);
		System.out.println("one data, but no url: ".concat(of.getValidUrl(results)));

		Result result2 = new Result("http://some.domain/path", "info");
		results.add(result2);
		System.out.println("two data, one has url: ".concat(of.getValidUrl(results)));
	}
}
