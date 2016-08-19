package com.home.jdbc;

import org.apache.commons.lang3.StringUtils;

public class SaPasswordDAO extends AbstractDAO {
	private static final String SQL_CHANGE_PASSWORD = "ALTER USER sa SET PASSWORD '{PASSWD}'";
	private static final String TAG_PASSWORD 		= "{PASSWD}";

	/**
	 * SA user password DAO constructor
	 * @param jdbcUrl - jdbc url
	 * @param username - database username
	 * @param password - database password
	 */
	public SaPasswordDAO(String jdbcUrl,
						String username,
						String password) {
		// no mapper
		super(jdbcUrl, username, password, null);
	}

	/**
	 * change password
	 * @param newPassword new password
	 */
	public void changePassword(String newPassword) {
		executeUpdate(StringUtils.replace(SQL_CHANGE_PASSWORD, TAG_PASSWORD, newPassword));
	}
}
