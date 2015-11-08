package com.myvest;

public class MultiplyTable {


	public void constructTable(int n) {
		//int [][] m = new int[n+1][n+1];  // initialize two dimentional array here

		StringBuilder sb = new StringBuilder();
		for(int i=0; i<=n; i++) {
			sb.delete(0, sb.length()); // remove any data on stringbuilder
			for(int j=0; j<=n; j++) {
				if(i==0 && j==0) {
					sb.append(" ");
					continue;
				}
				int v = j!=0?j:1; 
				int h = i!=0?i:1;
				//m[i][j]= v*h;
				if(sb.length() > 0) {
					sb.append(" ");
				}
				sb.append(v*h);
			}
			System.out.println(sb.toString());
		}
	}

	public static void main(String[] args) {
		MultiplyTable mt = new MultiplyTable();
		mt.constructTable(7);
	}

}
