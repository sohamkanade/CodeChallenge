package com.aws;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Donut mapping
 * 
 * @author spark
 *
 */
public class Solution3 {

	static String[][] matchDonuts(String[][] donutConstraintPairs, String[][] candidateConstraintPairs) {

		int donutNameNumber = donutConstraintPairs.length;
		int candidateNumber = candidateConstraintPairs.length;

		int resultRowNumber = 0;
		for(int i = 0; i < candidateNumber; i++) {
			if(candidateConstraintPairs[i][1].contains("*")) { // all choice
				resultRowNumber += donutNameNumber;
			} else {
				resultRowNumber++;
			}
		}

		// initialize result array size
		String[][] result = new String[resultRowNumber][2];

		// mapping
		int resultRow = 0;
		for(int i = 0; i < candidateNumber; i++) {
			if( candidateConstraintPairs[i][1].contains("*") ) { // all choice
				for(int j = 0; j < donutNameNumber; j++) {
					result[resultRow][0] = candidateConstraintPairs[i][0];	// set candidate name
					result[resultRow][1] = donutConstraintPairs[j][0]; 		// set donut name
					resultRow++;
				}
			} else { // choice certain type
				result[resultRow][0] = candidateConstraintPairs[i][0]; // set candidate name
				for(int j = 0; j < donutNameNumber; j++) {
					if(candidateConstraintPairs[i][1].equalsIgnoreCase(donutConstraintPairs[j][1])) {
						// found match
						result[resultRow][1] = donutConstraintPairs[j][0];
						break; // maybe shouldn't break and keep adding match?
					}
				}
				resultRow++;
			}
		}
		
		// sort
		Arrays.sort(result, new Comparator<String[]>() {
			@Override
			public int compare(final String[] entry1, final String[] entry2) {
				final String name1 = entry1[0];
				final String name2 = entry2[0];
				final String donut1 = entry1[1];
				final String donut2 = entry2[1];
				if ( !name1.equalsIgnoreCase(name2)) {
					return name1.compareTo(name2);
				}
				return donut1.compareTo(donut2);
			}
		});
		return result;
	}

	public static void main(String[] args) {
//		String[][] donutConstraintPairs = {{"cruller", "vegan"}, {"beignet", "coffee"}};
//		String[][] candidateConstraintPairs = {{"rob", "coffee"}, {"beth", "vegan"}};

		String[][] donutConstraintPairs = {{"cruller", "vegan"}, {"eclair", "chocolate"}};
		String[][] candidateConstraintPairs = {{"jose", "vegan"}, {"john", "chocolate"}, {"mary", "*"}};

		String[][] result = matchDonuts(donutConstraintPairs, candidateConstraintPairs);
		for(int i = 0; i <result.length; i++) {
			System.out.println(result[i][0] + " " + result[i][1]);

		}
	}
}
