package com.home.jdbc;

import java.util.List;

public class JdbcTest {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:h2:file:/Users/spark/Desktop/work/TexturaLink/h2_password_change/textura-link-yardi";
		String username = "sa";
		String password = "new123";

		SaPasswordDAO dao = new SaPasswordDAO(jdbcUrl, username, password);
		dao.changePassword("pass123");

		PropertyDAO pdao = new PropertyDAO(jdbcUrl, username, "pass123", new PropertyMapper());
		List<Property> properties = pdao.getProperties();
		properties.stream().forEach(property -> {
			System.out.println(String.join(", ", property.getName(), property.getData(), property.getDescription()));
		});
	}
}
