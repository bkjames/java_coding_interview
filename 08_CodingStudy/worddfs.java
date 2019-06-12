package zTest;

import java.util.*;


public class Shortest2 {
	
	public static void main(String[] args) {
		int[][] grid = {{1,0,2,0,1},
				        {0,0,0,0,0},
				        {0,0,1,0,0},
				};
		
		String[][] board = {
				{"A","B","T","T","T"},
				{"T","C","D","E","T"},
				{"T","T","T","F","T"},
				{"B","A","H","G","F"},
				{"C","D","E","F","G"}
		};
		Shortest2 a = new Shortest2();
		System.out.println(a.shortestDis(board));
	}
	
	int[][] dir = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
	TrieNode root = new TrieNode();
	TrieNode p = root;
	StringBuilder sb = new StringBuilder();
	Map<String, String> map = new HashMap<>();
	int[] mapKey= {0,0} ;
	
	public int shortestDis(String[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		int[][] reach = new int[m][n];
	
		int countBuilding=0;
		
		//step1
		Queue<int[]> queue = new LinkedList<>();
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				
					queue.offer(new int[] {i,j});
					sb.append(grid[i][j]);
				    String a = String.valueOf(i);
				    String b = String.valueOf(j);
				    map.put(a+b, grid[i][j]);
					bfs(queue, grid, dp, reach, m, n);
					countBuilding++;
					System.out.println("=====dp===");
					print(dp);
					System.out.println("=====reach===");
					print(reach);
				
			}
		}
		
		for(String i : map.keySet()) {
			
			System.out.println("key "+i+" value :"+map.get(i));
			
		}
		System.out.println("map size "+map.size());
		//step2
//		int result = Integer.MAX_VALUE;
//		for(int i=0; i<m ; i++) {
//			for(int j=0; j<n; j++) {
//				if(grid[i][j]==0 && reach[i][j]== countBuilding) {
//					result =Math.min(result, dp[i][j]);
//				}
//			}
//		}
//		return result == Integer.MAX_VALUE ?-1:result;
		return countBuilding;
		
	}
	public void bfs(Queue<int[]> queue, String[][] grid, int[][] dp, int[][] reach, int m, int n) {
		int level =1;
		

		boolean[][] visited = new boolean[m][n];
		while(!queue.isEmpty()) {
			int size = queue.size();
			int[] quePeek = queue.peek();
		    System.out.println("peek : "+quePeek[0]+" "+quePeek[1]);
		    System.out.println("value: "+grid[quePeek[0]][quePeek[1]]);
		        
			for(int i=0; i<size; i++) {
				int[] curPoint = queue.poll();
				int x = curPoint[0];
				int y = curPoint[1];
				for(int j=0; j<4; j++) {
					int dx = x+ dir[j][0];
					int dy = y+ dir[j][1];
					if(dx<0 || dx>=m || dy <0 || dy>= n||  visited[dx][dy]) {
						continue;
					}
					
					    String c = grid[dx][dy];
					    System.out.println("c: "+c);
//					    sb.append(grid[i][j]);
					    String a = String.valueOf(dx);
					    String b = String.valueOf(dy);
					    map.put(a+b, grid[dx][dy]);
					    char charA = c.charAt(0);
					 
				
			        
					    
					queue.offer(new int[] {dx, dy});
					visited[dx][dy] =true;
					dp[dx][dy] += level;
					reach[dx][dy]++;
				}
			}
			level++;
			System.out.println("========level=========: "+level);
			System.out.println("========sb=========: "+sb);
		}
	}
	
	class TrieNode {
	    TrieNode[] next = new TrieNode[26];
	    String word;
	}
	
	boolean check(TrieNode p, String str) {
		
		return false;
		
	}
	
	void print(int[][] dp) {
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[i].length; j++) {
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
		}
	}
	

}
