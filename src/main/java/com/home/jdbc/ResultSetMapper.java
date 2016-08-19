package com.home.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ResultSetMapper {
	public List<?> map(ResultSet rs) throws SQLException; 
}
