package com.home.property;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertyHandler {

	public void write(String filepath) {
		Properties prop = new Properties();

		// this is resource try, so it would close 
		try (OutputStream output = new FileOutputStream(filepath)) {
			// set the properties value
			prop.setProperty("adapter.datasource.url", "jdbc:sqlserver://dfinterfaces2.texturallc.net:1433;databaseName=VPSample");
			prop.setProperty("adapter.datasource.username", "sa");
			prop.setProperty("adapter.datasource.hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
			prop.store(output, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void read(String filepath) {
		Properties prop = new Properties();
		try (InputStream input = new FileInputStream(filepath)) {
			// load a properties file
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("adapter.datasource.url"));
			System.out.println(prop.getProperty("adapter.datasource.username"));
			System.out.println(prop.getProperty("adapter.datasource.hibernate.dialect"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}

	public static void main(String[] args) {
		PropertyHandler propertyHandler = new PropertyHandler();
		String homepath = System.getProperty("user.home");
		String filepath = String.join(File.separator, homepath, "test.properties");
		propertyHandler.write(filepath);
		propertyHandler.read(filepath);
	}

}
