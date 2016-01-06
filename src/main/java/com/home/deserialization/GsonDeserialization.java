package com.home.deserialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonDeserialization {
	private static String data = "{\"request\":{\"mbean\":\"com.textura.link:name=ClientMonitor\",\"attribute\":\"Properties\",\"type\":\"read\"},\"value\":{\"schedule.cron.import.changeorders\":\"* */5 * ? * *\",\"schedule.cron.import.new.contracts\":\"* 5 6-23 ? * MON-SAT\"},\"timestamp\":1452095556,\"status\":200}";

	public static void main(String [] args) {
		Gson gson = new GsonBuilder().serializeNulls().create();
		JsonContainer container = gson.fromJson(data, JsonContainer.class);
		container.getValue().entrySet().stream().forEach(entry -> {System.out.println(String.join(": ", entry.getKey(), entry.getValue())); });
	}
}
