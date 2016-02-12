package com.home.format;

import static com.home.format.EmployeeCsvUtils.read;
import static com.home.format.EmployeeCsvUtils.write;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CsvReadWriteSolution {

	public static void main(String[] args) {
		try {
			// prepare data
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			List<Employee> employees = new ArrayList<>();
			Employee emp1 = new Employee("IT", "DEV", "John", 112, sdf.parse("06/12/1960"), new BigDecimal("90000.0"));
			Employee emp2 = new Employee("BUSINESS", "Product Owner", "Thomas", 82, sdf.parse("11/05/1965"), new BigDecimal("150000.0"));
			Employee emp3 = new Employee("IT", "QA", "Shean", 85, sdf.parse("11/05/1968"), new BigDecimal("80000.0"));
			employees.add(emp1);
			employees.add(emp2);
			employees.add(emp3);

			File path = new File("."); // get location
			File file = new File(path, "employees.csv");
			
			// write
			write(employees, file, true);

			// read
			Stream<Employee> result = read(file, true);
			result.forEach(System.out::println);
			
//			Arrays.asList(path.list())
//					.stream()
//					.filter(entity -> StringUtils.startsWith(entity, "fare") || StringUtils.startsWith(entity, "cost"))
//					.findFirst()
//					.ifPresent(System.out::println);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
