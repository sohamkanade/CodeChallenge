import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Find the longest string that can be made by combining the strings
 * So find shortest common substring to have longest combined string
 *
 * @author spark
 *
 */
public class longest_string {

	private static final String EMPTY_STRING = "";
	private static final String SPACE_STRING = " ";

	/**
	 * Find shortest common substring between two input strings
	 * But the substring should be the suffix of first input string
	 * and also prefix of second input string
	 * @param first input string to find suffix substring
	 * @param second input string to find prefix substring
	 * @return Shortest common substring if found, otherwise null
	 */
	public String findShortestCommonSubstring(String first, String second) {
		List<Integer> founds = new ArrayList<>();

		// In second string, find the index of matched character
		// for the last character of first string in second string
		for(int i = 0; i < second.length(); i++) {
			if(second.charAt(i) == first.charAt(first.length() - 1)) {
				founds.add(i);
			}
		}

		// check prefix substring of second is suffix substring of first or not
		for(int index : founds) {
			String prefix = second.substring(0, index + 1);
			if( first.endsWith(prefix) ) {
				return prefix;
			}
		}
		return null;
	}

	/**
	 * Build longest combined string by given two string with finding
	 * shortest common substring
	 * @param first input string to search suffix common substring
	 * @param second input string to search prefix common substring
	 * @return longest combined string if find common substring, otherwise empty string
	 */
	public String buildLongestCombinedString(String first, String second) {
		String substring = findShortestCommonSubstring(first, second);
		if(null != substring && !substring.isEmpty()) {
			return String.join(EMPTY_STRING, first, second.replaceFirst(substring, EMPTY_STRING));
		}
		return EMPTY_STRING;
	}

	/**
	 * Read input from file
	 * @param filepath input file path
	 * @return String type data read from input file
	 * @throws IOException when fail to read file
	 */
	private String readInputFile(String filepath) throws IOException {
		if( null != filepath && 0 < filepath.length() ) {
			List<String> lines = Files.readAllLines(Paths.get(filepath));
			return lines.stream().collect(Collectors.joining(EMPTY_STRING));
		}
		return EMPTY_STRING;
	}

	/**
	 * Write output to file
	 * @param filepath output filepath
	 * @param data string data to write
	 * @throws FileNotFoundException when fail to find file
	 * @throws UnsupportedEncodingException when character encoding issue
	 */
	private void writeOutputFile(String filepath, String data) throws FileNotFoundException, UnsupportedEncodingException {
		try(PrintWriter writer = new PrintWriter(filepath, "UTF-8")) {
			writer.print(data);
		}
	}

	/**
	 * Main method to handle command
	 * command: java longest_string <input_file> <output_file>.
	 * @param args input arguments, args[0] is for input filename and args[1] is for output filename
	 */
	public static void main(String[] args) {
		if( 2 <= args.length ) {
			longest_string process = new longest_string();
			try {
				// read data from input file
				String data = process.readInputFile(args[0]);
				if(null != data && !data.isEmpty()) {
					List<String> results = new ArrayList<>();
					// split input data to fragments by white space
					String[] fragments = data.split(SPACE_STRING);

					// make combined string with fragments
					// we care which fragment for finding suffix and which fragment for prefix
					// so try to combine by all the possible permutation
					for(int i = 0; i < fragments.length; i++) {
						for(int j = 0; j < fragments.length; j++) {
							if(i == j) {
								continue;
							}
							String combined = process.buildLongestCombinedString(fragments[i], fragments[j]);
							if(null != combined && !combined.isEmpty()) {
								results.add(combined);
							}
						}
					}

					// write result to output file
					process.writeOutputFile(args[1], results.stream().collect(Collectors.joining(SPACE_STRING)));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
