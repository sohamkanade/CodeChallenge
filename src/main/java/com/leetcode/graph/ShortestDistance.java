package com.leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0

 * @author spark
 *
 */
public class ShortestDistance {
	public int shortestDistance(int[][] grid) {
		int rows = grid.length;
		if (rows == 0) {
			return -1;
		}
		int cols = grid[0].length;

		int[][] dist = new int[rows][cols];
		int[][] nums = new int[rows][cols];
		int buildingNum = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					buildingNum++;
					bfs(grid, i, j, dist, nums);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 0 && dist[i][j] != 0 && nums[i][j] == buildingNum)
					min = Math.min(min, dist[i][j]);
			}
		}
		if (min < Integer.MAX_VALUE)
			return min;
		return -1;
	}

	public void bfs(int[][] grid, int row, int col, int[][] dist, int[][] nums) {
		int rows = grid.length;
		int cols = grid[0].length;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{row, col});
		int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

		boolean[][] visited = new boolean[rows][cols];
		int level = 0;
		while (!q.isEmpty()) {
			level++;
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] coords = q.remove();
				for (int k = 0; k < dirs.length; k++) {
					int x = coords[0] + dirs[k][0];
					int y = coords[1] + dirs[k][1];
					if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && grid[x][y] == 0) {
						visited[x][y] = true;
						dist[x][y] += level;
						nums[x][y]++;
						q.add(new int[]{x, y});
					}
				}
			}
		}
	}
}
