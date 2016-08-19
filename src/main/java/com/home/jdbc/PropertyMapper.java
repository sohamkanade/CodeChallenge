package com.home.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PropertyMapper implements ResultSetMapper {

	@Override
	public List<?> map(ResultSet rs) throws SQLException {
		List<Property> properties = new ArrayList<>();
		while(rs.next()) {
			Property property = new Property();
			property.setName(rs.getString("NAME"));
			property.setData(rs.getString("DATA"));
			property.setDescription(rs.getString("DESCRIPTION"));
			properties.add(property);
		}
		return properties;
	}

}
