package com.home.format;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public class EmployeeCsvUtils {

	private EmployeeCsvUtils() {}

	/**
	 * Write employee list to csv file
	 * @param employees list of employee
	 * @param file output csv file
	 * @param isHeader
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	public static void write(List<Employee> employees, File file, boolean isHeader) throws JsonGenerationException, JsonMappingException, IOException  {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(Employee.class);
		ObjectWriter writer = mapper.writer(isHeader ? schema.withHeader() : schema);
		writer.writeValue(file, employees);
	}

	/**
	 * Read and parse csv file to stream of employee
	 * @param file csv file to read
	 * @param isHeader
	 * @return employee stream 
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static Stream<Employee> read(File file, boolean isHeader) throws JsonProcessingException, IOException {
		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(Employee.class);
		MappingIterator<Employee> iterator = mapper.readerFor(Employee.class).with(isHeader ? schema.withHeader() : schema).readValues(file);
		Iterable<Employee> iterable = () -> iterator;
		return StreamSupport.stream(iterable.spliterator(), false);
	}
}
