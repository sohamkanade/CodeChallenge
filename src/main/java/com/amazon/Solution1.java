package com.amazon;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
 * threshold
 * number of input
 * affinity probability
 * 
 * 0.15
 * 4
 * Item1 Item2 0.2
 * Item2 Item3 0.1
 * Item4 Item5 0.3
 * Item5 Item6 0.4
 * 
 * (item1, Item2) , (Item4, Item5, Item6)
 * => Item4
 * @author spark
 *
 */
public class Solution1 {

	public static void main(String args[]) throws Exception {
		List<Set<String>> clusters = new ArrayList<>();

		try( Scanner scan = new Scanner(System.in) ) {
			double threshold = Double.parseDouble(scan.nextLine());
			int inputLineSize = Integer.parseInt(scan.nextLine());

			// build clusters
			for(int i =0; i < inputLineSize; i++) {
				String input = scan.nextLine();
				String[] parsed = input.split(" ", 3);
				String item1 = null;
				String item2 = null;
				double prob = 0.0;
				boolean foundMatch = false;
				if(parsed.length >=3) {
					item1 = parsed[0];
					item2 = parsed[1];
					prob = Double.parseDouble(parsed[2]);
				} else if (parsed.length <3) {
					item1 = parsed[0];
				}
				if( threshold <= prob ) {
					for(int j=0; j < clusters.size(); j++) {
						if((item1 != null && clusters.get(j).contains(item1))
							|| (item2 != null && clusters.get(j).contains(item2)) ) {
							foundMatch = true;
							if(null != item1) {
								clusters.get(j).add(item1);
							}
							if(null != item2) {
								clusters.get(j).add(item2);
							}
							break;
						}
					}
					if(!foundMatch) {
						Set<String> set = new TreeSet<>();
						if(null != item1) {
							set.add(item1);
						}
						if(null != item2) {
							set.add(item2);
						}
						clusters.add(set);
					}
				}
			}
			
			int biggestClusterSize = 0;
			int biggestClusterIndex = 0;

			// find biggest cluster
			if(!clusters.isEmpty()) {
				for(int i =0 ; i< clusters.size(); i++) {
					if( biggestClusterSize < clusters.get(i).size()) {
						biggestClusterSize = clusters.get(i).size();
						biggestClusterIndex = i;
					}
				}

				Set<String> set = clusters.get(biggestClusterIndex);
				Iterator<String> it = set.iterator();
				System.out.println(it.next());
			}
		}
	}
}
