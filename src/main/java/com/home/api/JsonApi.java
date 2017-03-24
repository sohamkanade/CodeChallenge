package com.home.api;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonApi {

	public static void main(String[] args) {
		
		ErpRecords records = new ErpRecords();
		
		Calendar invoiceCalendar = Calendar.getInstance();
		invoiceCalendar.set(2009, Calendar.MARCH, 1, 10, 0);
		ZonedDateTime zdtInvoice = ZonedDateTime.ofInstant(invoiceCalendar.toInstant(), ZoneId.of("UTC")).truncatedTo(ChronoUnit.SECONDS);
		
		Calendar paymentCalendar = Calendar.getInstance();
		paymentCalendar.set(2015, Calendar.JULY, 1, 11, 0);
		ZonedDateTime zdtPayment = ZonedDateTime.ofInstant(paymentCalendar.toInstant(), ZoneId.of("UTC")).truncatedTo(ChronoUnit.SECONDS);

		Calendar rejectionCalendar = Calendar.getInstance();
		rejectionCalendar.set(2009, Calendar.JANUARY, 1, 12, 0);
		ZonedDateTime zdtRejection = ZonedDateTime.ofInstant(rejectionCalendar.toInstant(), ZoneId.of("UTC")).truncatedTo(ChronoUnit.SECONDS);

		ErpRecord invoiceRecord = new ErpRecord("1",
												"213", 
												"1", 
												"invoice", 
												StringUtils.strip(zdtInvoice.toString(), "[UTC]"), 
												"1-1000-", 
												"1000-01", 
												"Paid Bal Fwd", 
												null,
												"1215",
												null,
												new BigDecimal("21597.40"), 
												new BigDecimal("50.00"),
												null);
		ErpRecord paymentRecord = new ErpRecord("18", 
												null, 
												"1", 
												"payment", 
												StringUtils.strip(zdtPayment.toString(), "[UTC]"), 
												null, 
												null, 
												"1-1000-10", 
												null, 
												"1100",
												"18",
												null, 
												null, 
												new BigDecimal("30000"));
		ErpRecord rejectionRecord = new ErpRecord("17", 
												null, 
												"1", 
												"rejection", 
												StringUtils.strip(zdtRejection.toString(), "[UTC]"), 
												"2-1008-", 
												"1008-1775", 
												"App 1", 
												"a", 
												"1775",
												null,
												new BigDecimal("29200.00"), 
												null, 
												null);
		
		records.getRecords().addAll(Arrays.asList(invoiceRecord, paymentRecord, rejectionRecord));
		Gson gson = new GsonBuilder().serializeNulls().create();
		String payload = gson.toJson(records);
		System.out.println(payload);
	}
}
