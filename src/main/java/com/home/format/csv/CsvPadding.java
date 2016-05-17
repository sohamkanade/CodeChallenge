package com.home.format.csv;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * Create CSV format with one value column and others are empty values
 * @author spark
 *
 */
public class CsvPadding {
	public static final String CSV_DELIMITER						= ",";

	public static void main(String[] args) {
		int numberOfCustomFields = 5; 
		int changeOrderIdPosition = 3;
		String changeOrderId = "VIM";

		// works but not fun
		StringBuilder customFields = new StringBuilder();
					customFields.append( StringUtils.repeat(CSV_DELIMITER, changeOrderIdPosition-1))
								.append(changeOrderId)
								.append(StringUtils.repeat(CSV_DELIMITER, numberOfCustomFields - changeOrderIdPosition));
		System.out.println(customFields.toString());

		// bad example
		String custom2 = StringUtils.rightPad(StringUtils.leftPad(changeOrderId, 
																changeOrderIdPosition + changeOrderId.length(), 
																CSV_DELIMITER),
											numberOfCustomFields + changeOrderId.length(), 
											CSV_DELIMITER);
		System.out.println(custom2);

		// simple
		List<String> list = new ArrayList<>(Collections.nCopies(numberOfCustomFields, ""));
		list.set(changeOrderIdPosition-1, changeOrderId);
		String custom3 = list.stream().collect(Collectors.joining(CSV_DELIMITER));
		System.out.println(custom3);
	}
}
