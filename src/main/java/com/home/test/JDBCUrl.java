package com.home.test;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.lang3.StringUtils;

public class JDBCUrl {

	public static void main(String[] args) throws SQLException, IOException {
//		String url = "jdbc:h2:file:~/TexturaLinkMillCreek/textura-link-db;AUTO_SERVER=TRUE";
		String url = "jdbc:h2:file:C:\\TexturaLinkMillCreek\\textura-link-db;AUTO_SERVER=TRUE";
		String cleanUrl = StringUtils.replace(url, "jdbc:h2:file:", "");
		String[] values = StringUtils.split(cleanUrl, ";");
		File dbfile = new File(StringUtils.replacePattern(values[0], "^~",System.getProperty("user.home")));
		System.out.println(dbfile.getAbsolutePath());
		
	}
}
