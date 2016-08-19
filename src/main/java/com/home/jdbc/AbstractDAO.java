package com.home.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class AbstractDAO {
	private static final String JDBC_DRIVER = "org.h2.Driver";

	private String jdbcUrl;
	private String username;
	private String password;
	private Optional<ResultSetMapper> mapper = Optional.empty();

	/**
	 * 
	 * @param jdbcUrl - jdbc url
	 * @param username - database username
	 * @param password - database password
	 * @param rsMapper - resultSet mapper
	 */
	public AbstractDAO(String jdbcUrl,
							String username,
							String password,
							ResultSetMapper mapper) {
		this.jdbcUrl = jdbcUrl;
		this.username = username;
		this.password = password;

		if(null != mapper) {
			this.mapper = Optional.of(mapper);
		}
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	private void connectionHandler(Function<Statement, Object> func) {
		try( Connection conn = DriverManager.getConnection(jdbcUrl, username, password) ) {
			try( Statement stmt = conn.createStatement() ) {
				func.apply(stmt);
			} catch(Exception se) {
				System.out.println(se.getMessage());
			}
		} catch(Exception ce) {
			System.out.println(ce.getMessage());
		}
	}

	protected List<?> executeQuery(String query) {
		List<Object> results = new ArrayList<>();
		connectionHandler((Statement stmt) -> {
			try(ResultSet rs = stmt.executeQuery(query)) {
				if(mapper.isPresent()) {
					results.addAll(mapper.get().map(rs));
				}
			} catch(Exception re) {
				System.out.println(re.getMessage());
			}
			return null;
		});
		return results;
	}

	/**
	 * execute queries for change / update
	 * @param queries - list of sql queries for update ex) INSERT, UPDATE and DELETE 
	 */
	protected void executeUpdate(List<String> queries) {
		connectionHandler((Statement stmt) -> {
			queries.stream().forEach(query -> {
				try {
					stmt.executeUpdate(query);
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			});
			return true;
		});
	}

	protected void executeUpdate(String query) {
		List<String> queries = new ArrayList<>();
		queries.add(query);
		executeUpdate(queries);
	}
}
