package ama02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheMaze2 {

	public static void main(String[] args) {
		int[][] maze = {
				   {0,0,1,0,0},
				   {0,0,0,0,0},
				   {0,0,0,1,0},
				   {1,1,0,1,1},
				   {0,0,0,0,0}
		};
		
		int[] start = {0,4};
		int[] dest= {4,4};
//		System.out.println(shortestDistance(maze, start, dest));
//		System.out.println(hasPath(maze, start, dest));
		System.out.println(shortestDistance(maze, start, dest));
	}
	
	
	  // directions to top, bottom, left and right
//    int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
	public static int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] row: distance)
            Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
         int[][] dirs={{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};
        Queue < int[] > queue = new LinkedList < > ();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                int count = 0;
                System.out.println("aaaaaaaaa x: "+x+" y: "+y);
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                	System.out.println("x: "+x+" y: "+y);
                    x += dir[0];
                    y += dir[1];
                    count++;
                    System.out.println("x: "+x+" y: "+y);
                }
                if (distance[s[0]][s[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                	
                	System.out.println((distance[s[0]][s[1]] + count)+" "+distance[x-dir[0]][y-dir[1]]+
                			           " distance["+s[0]+"]"+"["+s[1]+"]"+" count: "+count+" distance["+(x-dir[0])+"]["+(y-dir[1])+"]");
                	
                	System.out.println("x: "+x+" dir[0]: "+dir[0]+"  x - dir[0]: "+(x - dir[0])+" "+distance[x - dir[0]][y - dir[1]]);
                	System.out.println("y: "+x+" dir[1]: "+dir[1]+"  y - dir[1]: "+(y - dir[1])+" "+distance[x - dir[0]][y - dir[1]]);
                	
                    distance[x - dir[0]][y - dir[1]] = distance[s[0]][s[1]] + count;
                	System.out.println("value "+(x - dir[0])+" "+(y - dir[1])+" "+ distance[x - dir[0]][y - dir[1]]);
                	System.out.println();
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                }
            }
        }
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }
	
	
	
	public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
	        boolean[][] visited = new boolean[maze.length][maze[0].length];
	        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	        Queue < int[] > queue = new LinkedList < > ();
	        queue.add(start);
	        visited[start[0]][start[1]] = true;
	        while (!queue.isEmpty()) {
	            int[] s = queue.remove();
	            if (s[0] == destination[0] && s[1] == destination[1])
	                return true;
	            for (int[] dir: dirs) {
	                int x = s[0] + dir[0];
	                int y = s[1] + dir[1];
	                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
	                    x += dir[0];
	                    y += dir[1];
	                }
	                if (!visited[x - dir[0]][y - dir[1]]) {
	                    queue.add(new int[] {x - dir[0], y - dir[1]});
	                    visited[x - dir[0]][y - dir[1]] = true;
	                }
	            }
	        }
	        return false;
	    }
}
