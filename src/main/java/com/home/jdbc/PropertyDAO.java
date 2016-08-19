package com.home.jdbc;

import java.util.List;

public class PropertyDAO extends AbstractDAO {

	public PropertyDAO(String jdbcUrl,
						String username,
						String password,
						PropertyMapper mapper) {
		super(jdbcUrl, username, password, mapper);
	}

	@SuppressWarnings("unchecked")
	public List<Property> getProperties() {
		return (List<Property>)executeQuery("SELECT * FROM PROPERTIES");
	}
}
