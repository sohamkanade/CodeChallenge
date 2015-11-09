package com.home.count;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LDRCheck {

	public Stream<String> getJobHasChangedStatus(String filepath) {
		Stream<String> jobTitles = null;
		try( Stream<String> lines = Files.lines(Paths.get(filepath), Charset.defaultCharset()) ) {
			// LDR,368,AUTO INSURANCE-TEXTURA JOBS ONLY,Y,,,N
			jobTitles = lines.filter(line -> line.startsWith("LDR"))	// get LDR line
			.map(line -> {
				String[] elements = line.split(",");	// split by comma
				if(elements[3].isEmpty()) {
					elements[3] ="Y";
				}
				return new SimpleEntry<String, String>(elements[3], String.join(":", elements[1], elements[2]) );	// key is 4th element and value is joining 2nd (jobId) and 3rd (jobTitle), so actually coss mapping here.
			})
			.collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toSet())))
			.entrySet()
			.stream()
			.filter(entry -> entry.getValue().size() > 1)	// filter by having Y, N both
			.map(entry -> entry.getKey());					// get jobId and title
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		return jobTitles;
	}

	public Stream<String> getAllFilesUnderfolder(String folderPath) {
		File folder = new File(folderPath);
		return Arrays.stream(folder.listFiles()).map(file -> file.getName());
	}

	public static void main(String[] args) {
		String folderPath = "./src/main/resources/Fransen_Pittman_Compliance_Import_INCMGMT-5216";
		LDRCheck ldrCheck = new LDRCheck();
		ldrCheck.getAllFilesUnderfolder(folderPath)
				.filter(fileName -> !fileName.equalsIgnoreCase(".DS_Store"))
				.forEach(fileName -> {
			System.out.println( String.join(": [", fileName, ldrCheck.getJobHasChangedStatus(String.join("/", folderPath, fileName)).collect(Collectors.joining(", ")).concat("]") ) );
		});
	}
}
