package com.xad;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * xAD Coding Exercise
 * 
 * GTFS Transit Data
 * http://www.sfmta.com/about-sfmta/reports/gtfs-transit-data
 * 
 * GTFS Reference
 * https://developers.google.com/transit/gtfs/reference
 * 
 * @author spark
 *
 */
public class RouteProcess {

	private static final String DELIMITER				= ",";
	private static final String EMPTY_STRING			= "";
	private static final String KEY_ROUTE_NAME_SHORT 	= "short";
	private static final String KEY_ROUTE_NAME_LONG 	= "long";
	private static final String KEY_ROUTE_TYPE			= "type";
	private static final String HEADER_TOTAL_ROUTES		= "route_type,num_routes";
	private static final String HEADER_ROUTE_COST		= "route_short_name,route_long_name,price";
	
	private static final Map<String, String> ROUTE_TYPES = new HashMap<>();
	{
		ROUTE_TYPES.put("0", "Tram");		// Streetcar, Light rail
		ROUTE_TYPES.put("1", "Subway");
		ROUTE_TYPES.put("2", "Rail");
		ROUTE_TYPES.put("3", "Bus");
		ROUTE_TYPES.put("4", "Ferry");
		ROUTE_TYPES.put("5", "Cable car");
		ROUTE_TYPES.put("6", "Gondola"); 	// Suspended cable car
		ROUTE_TYPES.put("7", "Funicular");	// Any rail system designed for steep inclines
	}

	/**
	 * Parse input lines and build MultiMap contains route id as key
	 * and attributes map as value 
	 * @param lines list of string type data from input file
	 * @return routes MultiMap
	 */
	public final Map<Integer, Map<String, String>> parseRoutes(Stream<String> lines) {
		Map<Integer, Map<String, String>> routes = new HashMap<>();

		// skip first line which is header
		lines.skip(1).forEach(line -> {
			// route_id,agency_id,route_short_name,route_long_name,route_desc,route_type,route_url,route_color,route_text_color
			String[] data = line.split(DELIMITER);
			if(6 <= data.length) {
				Map<String, String> attributes = new HashMap<>();
				attributes.put(KEY_ROUTE_NAME_SHORT, data[2].trim());
				attributes.put(KEY_ROUTE_NAME_LONG, data[3].trim());
				attributes.put(KEY_ROUTE_TYPE, data[5].trim());
				routes.put(Integer.valueOf(data[0].trim()), attributes);
			}
		});
		return routes;
	}

	/**
	 * Parse input lines and build fare rule map contains route id as key
	 * and fare id as value
	 * @param lines list of string type data from input file
	 * @return fare rule map
	 */
	public final Map<Integer, Integer> parseFareRules(Stream<String> lines) {
		Map<Integer, Integer> fareRules = new HashMap<>();
		// skip first line as header
		lines.skip(1).forEach(line -> {
			// fare_id,route_id,origin_id,destination_id,contains_id
			String[] data = line.split(DELIMITER);
			if(2 <= data.length) {
				fareRules.put(Integer.valueOf(data[1].trim()), Integer.valueOf(data[0].trim()));
			}
		});
		return fareRules;
	}

	/**
	 * Parse input lines and build fare attribute map contains fare id ad key
	 * and price as value
	 * @param lines list of string type data from input file
	 * @return fare attribute map
	 */
	public final Map<Integer, BigDecimal> parseFareAttributes(Stream<String> lines) {
		Map<Integer, BigDecimal> fareAttributes = new HashMap<>();
		// skip first line as header
		lines.skip(1).forEach(line -> {
			// fare_id,price,currency_type,payment_method,transfers,transfer_duration
			String[] data = line.split(DELIMITER);
			if(2 <= data.length) {
				fareAttributes.put(Integer.valueOf(data[0].trim()), new BigDecimal(data[1].trim()));
			}
		});
		return fareAttributes;
	}

	/**
	 * Build results for Total Number of Routes by Route Type
	 * @param routes MultiMap contains route id as key and attributes as value
	 * @return list of string type result lines
	 */
	public List<String> buildTotalNumberRoutesByType(final Map<Integer, Map<String, String>> routes) {
		List<String> lines = new ArrayList<>();
		lines.add(HEADER_TOTAL_ROUTES);
		ROUTE_TYPES.entrySet().forEach(typeEntry -> {
			String type = typeEntry.getValue();
			Long number = routes.entrySet().stream().filter(routeEntry -> routeEntry.getValue().get(KEY_ROUTE_TYPE).equals(typeEntry.getKey()) ).count();
			lines.add(String.join(DELIMITER, type, number.toString()));
		});
		return lines;
	}

	/**
	 * Build results for Cost of Routes
	 * @param routes MultiMap contains route id as key and attributes as value
	 * @param fareRules map contains route id as key and fare id as value
	 * @param fareAttributes map contains fare id as key and price as value
	 * @return list of string type result lines
	 */
	public List<String> buildCostOfRoutes(final Map<Integer, Map<String, String>> routes, 
										final Map<Integer, Integer> fareRules,
										final Map<Integer, BigDecimal> fareAttributes) {
		List<String> lines = new ArrayList<>();
		lines.add(HEADER_ROUTE_COST); // add header line
		routes.entrySet().forEach(entry -> {
			String shortName = entry.getValue().get(KEY_ROUTE_NAME_SHORT);
			String longName = entry.getValue().get(KEY_ROUTE_NAME_LONG);
			Integer fareId = fareRules.get(entry.getKey());
			BigDecimal price = null;
			if(null != fareId) {
				price = fareAttributes.get(fareId);
			}
			// if unable to find price, then print dash
			lines.add( String.join(DELIMITER, shortName, longName, price != null ? price.toPlainString() : EMPTY_STRING) );
		});
		
		return lines;
	}

	/**
	 * Read input from file
	 * @param filepath input file path
	 * @return String type data read from input file
	 * @throws IOException when fail to read file
	 */
	private Stream<String> readFile(String filepath) throws IOException {
		if( null != filepath && 0 < filepath.length() ) {
			Stream<String> lines = Files.lines(Paths.get(filepath));
			return lines;
		}
		throw new IllegalArgumentException("Invalid input filepath");
	}

	/**
	 * Write output to file
	 * @param filepath output file path
	 * @param lines data to save
	 * @throws FileNotFoundException exception when fail to find file
	 * @throws UnsupportedEncodingException exception for encoding type
	 */
	private void writeFile(String filepath, List<String> lines) throws FileNotFoundException, UnsupportedEncodingException {
		try(PrintWriter writer = new PrintWriter(filepath, "UTF-8")) {
			lines.stream().forEach(line -> writer.println(line));
		}
	}

	/**
	 * Main method to run this process
	 * Please run this with providing filenames as input arguments
	 * 
	 * ex) RouteProcess routes.txt fare_rules.txt fare_attributes.txt
	 * 
	 * @param args input arguments
	 */
	public static void main(String[] args) {
		try {
//			if( 3 > args.length) {
//				throw new IllegalArgumentException("Not enough input files are given, ex) RouteProcess routes.txt fare_rules.txt fare_attributes.txt");
//			}
			RouteProcess rp = new RouteProcess();
			// read data
			Map<Integer, Map<String, String>> routes = rp.parseRoutes(rp.readFile("routes.txt"));
			Map<Integer, Integer> fareRules = rp.parseFareRules(rp.readFile("fare_rules.txt"));
			Map<Integer, BigDecimal> fareAttributes = rp.parseFareAttributes(rp.readFile("fare_attributes.txt"));
			// 1. Total number of routes by route_type
			rp.writeFile("number_of_routes.csv", rp.buildTotalNumberRoutesByType(routes));
			// 2. Cost of routes
			rp.writeFile("cost_of_routes.csv", rp.buildCostOfRoutes(routes, fareRules, fareAttributes));
		} catch(Exception e) {
			System.out.println( String.join(": ", "error", e.getMessage()) );
		}
		System.out.println("finish route process!");
	}
}
