package com.leetcode.sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConnectedComponents {
	public int countComponents(int n, int[][] edges) {
		List<Set<Integer>> components= new ArrayList<>();
		if(null != edges && 0 != edges.length) {
			for(int[] edge : edges) {
				int compNum1 = -1;
				int compNum2 = -1;
				for(int i = 0; i < components.size(); i++) {
					if(components.get(i).contains(edge[0])) {
						compNum1 = i;
						if(!components.get(i).contains(edge[1])) {
							components.get(i).add(edge[1]);
							compNum2 = i;
						}
					}
					if(components.get(i).contains(edge[1])) {
						compNum2 = i;
						if(!components.get(i).contains(edge[0])) {
							components.get(i).add(edge[0]);
							compNum1 = i;
						}
					}
				}
				if( compNum1 == -1 && compNum2 == -1) {
					Set<Integer> set = new HashSet<>();
					set.add(edge[0]);
					set.add(edge[1]);
					components.add(set);
				} else if( compNum1 != compNum2) {
					components.get(compNum1).addAll(components.get(compNum2));
					components.remove(compNum2);
				}
			}
		}
		
		return components.size() + (n - components.stream().map(comp -> comp.size()).reduce(0, (a, b) -> a+b));
	}

	public static void main(String[] args) {
		//		5
		//		[[0,1],[1,2],[0,2],[3,4]]
		int [][] edges = {{0,1}, {1,2}, {0,2}, {3,4}};
		System.out.println( new ConnectedComponents().countComponents(5, edges) );

		//		n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
		int [][] edges1 = {{0,1}, {1,2}, {3,4}};
		System.out.println( new ConnectedComponents().countComponents(5, edges1) );

		//		n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
		int [][] edges2 = {{0,1}, {1,2}, {2, 3}, {3,4}};
		System.out.println( new ConnectedComponents().countComponents(5, edges2) );


		//		0
		//
		//		1
		//		| \
		//		2 - 3

		//		4
		//		[[2,3],[1,2],[1,3]]
		int [][] edges3 = {{2, 3}, {1,2}, {1,3}};
		System.out.println( new ConnectedComponents().countComponents(4, edges3) );


		//		4
		//		[[0,1],[2,3],[1,2]]

		//		0
		//		|
		//		1 - 2 - 3
		int [][] edges4 = {{0,1}, {2,3}, {1,2}};
		System.out.println( new ConnectedComponents().countComponents(4, edges4) );

		int [][] edges5 = {};
		System.out.println( new ConnectedComponents().countComponents(0, edges5) );

		//		6
		//		[[0,1],[0,2],[2,5],[3,4],[3,5]]
		//	            3 - 4
		//		        |
		//		0 - 2 - 5
		//		|
		//		1

		int [][] edges6 = {{0,1},{0,2},{2,5},{3,4},{3,5}};
		System.out.println( new ConnectedComponents().countComponents(6, edges6) );

		//		5
		//		[[2,3],[1,2],[1,3],[0,4]]

		//		2 - 1
		//		|  /
		//		3
		//		
		//		0 - 4

		int [][] edges7 = {{2,3},{0,2},{2,5},{3,4},{3,5}};
		System.out.println( new ConnectedComponents().countComponents(5, edges7) );

		//		2
		//		[[0,1]]
		int [][] edges8 = {{0,1}};
		System.out.println( new ConnectedComponents().countComponents(2, edges8) );

		//		6
		//		[[0,1],[1,2],[2,0],[3,4],[4,5]]

		//		0 
		//		| \
		//		1 - 2  3 - 4 - 5
		int [][] edges9 = {{0,1}, {1,2}, {2,0},{3,4},{4,5}};
		System.out.println( new ConnectedComponents().countComponents(6, edges9) );

		//		8
		//		[[1,0],[2,6],[1,7],[6,4],[7,0],[0,5]]

		//		1 - 0 - 5
		//		| /
		//		7
		//		
		//		2 - 6 - 4
		int [][] edges10 = {{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}};
		System.out.println( new ConnectedComponents().countComponents(8, edges10) );

	}
}



/* provided solution from others

public class Solution {
    public int countComponents(int n, int[][] edges) {
        unionFind uf = new unionFind(n);
        for (int[] edge : edges) {
            if (!uf.isConnected(edge[0], edge[1])) {
                uf.union(edge[0], edge[1]);
            }
        }
        return uf.findCount();
    }

    public class unionFind{
            int[] ids;
            int count;

            public unionFind(int num) {
                this.ids = new int[num];
                for (int i=0; i<num; i++) {
                    ids[i] = i;
                }
                this.count = num;
            }

            public int find(int i) {
                return ids[i];
            }

            public void union(int i1, int i2) {
                int id1 = find(i1);
                int id2 = find(i2);
                if (id1 != id2) {
                    for (int i=0; i<ids.length; i++) {
                        if (ids[i] == id2) {
                            ids[i] = id1;
                        }
                    }
                    count--;
                }
            }

            public boolean isConnected(int i1, int i2) {
                return find(i1)==find(i2);
            }

            public int findCount() {
                return count;
            }
        }
}
*/
