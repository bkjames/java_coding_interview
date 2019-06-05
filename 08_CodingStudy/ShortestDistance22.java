package exam;

import java.util.*;



 public class ShortestDistance {

		public static void main(String[] args) {
			String[][] grid ={
					  {"A","B","T","T","T"},
					  {"T","C","D","E","T"},
					  {"T","T","T","F","T"},
					  {"B","A","H","G","F"},
					  {"C","D","E","F","G"},
					};
			ShortestDistance a = new ShortestDistance();
			System.out.println("result : "+a.shortestDistance(grid));

		}
		final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		TrieNode root ;
		 
		public int shortestDistance(String[][] grid) {
		    int n = grid.length;
		    int m = grid[0].length;
		    int[][] dp = new int[n][m];
		    int[][] reach = new int[n][m];
		    int countBuilding = 0;
		   
		    Queue<int[]> queue = new LinkedList<>();
		    // step 1
		    for (int i = 0; i < n; i++) {
		        for (int j = 0; j < m; j++) {
		            
		                queue.offer(new int[]{i, j});
		                bfs(queue, grid, dp, reach, n, m, i, j);
		                countBuilding++;
		                print(dp);
		            
		        }
		    }

		    // step 2
		    int result = Integer.MAX_VALUE;
		    for (int i = 0; i < n; i++) {
		        for (int j = 0; j < m; j++) {
		            // WARNING: DO NOT FORGET to check whether current point is 0 and whether current point can reach all buildings
//		            if (grid[i][j] == 0 && reach[i][j] == countBuilding) {
		                result = Math.min(result, dp[i][j]);
//		            }
		                getValue(root);
		        }
		    }
		    return result == Integer.MAX_VALUE ? -1 : result;
		}
		
		
		public void getValue(TrieNode p) {
		  
		 
//		    System.out.println("TrieNode p.word: "+p.word);
		
		}


		public void bfs(Queue<int[]> queue, String[][] grid, int[][] dp, int[][] reach, int n, int m,int a, int b) {
		    int level = 1;
		    // DO NOT USE hashset, since hashset cannot determine whether it contains an array (coordinate)
		    boolean[][] visited = new boolean[n][m];
		    System.out.println("grid["+a+"]["+b+"]: "+grid[a][b]);
		    visited[a][b]= true;
		    String str ="";
		    while (!queue.isEmpty()) {
		        int size = queue.size();
		        System.out.println("size: "+size);
		        int[] quePeek = queue.peek();
//		        System.out.println("peek: "+quePeek[0]+" "+quePeek[1]);
		        
		        for (int i = 0; i < size; i++) {
		            int[] curPoint = queue.poll();
		            int x = curPoint[0];
		            int y = curPoint[1];
//		            System.out.println("x: "+x+" y: "+y);
		            
//		            System.out.println("====str: "+str);
		            for (int j = 0; j < 4; j++) {
		                int dx = x + dir[j][0];
		                int dy = y + dir[j][1];
//		                System.out.println("before dx: "+dx+" dy: "+dy);
		                if (dx < 0 || dx > n - 1 || dy < 0 || dy > m - 1 ||  visited[dx][dy]) {
		                    continue;
		                }
		                System.out.println("dx: "+dx+" dy: "+dy);
		              
		                queue.offer(new int[]{dx, dy});
		                System.out.println("grid["+dx+"]["+dy+"]: "+grid[dx][dy]);
//			            str+=grid[x][y];
//		                root = buildTrie(grid[x][y]);  
			            
		                visited[dx][dy] = true;
		                dp[dx][dy] += level;
		                reach[dx][dy]++;
		            }
		        }
		      
		        level++;
		        System.out.println("========level=========: "+level);
		    }
		}
		
		void print(int[][] dp) {
			System.out.println("===================================dp==");
			for(int i=0; i<dp.length; i++) {
				for(int j=0; j<dp[i].length;j++) {
					System.out.print(dp[i][j]+"\t");
				}
				System.out.println();
			}
			System.out.println("===================================dp==");
		}
		
		public TrieNode buildTrie(String words) {
		    TrieNode root = new TrieNode();
//		    for (String w : words) {
		        TrieNode p = root;
		        System.out.println("p "+p.next);
		        for (char c : words.toCharArray()) {
		            int i = c - 'A';
		            System.out.println("i: "+i);
		            if (p.next[i] == null) {
		            	p.next[i] = new TrieNode();
		            }
		            p = p.next[i];
		       }
		       p.word += words;
		       System.out.println("-----p.word: "+p.word);
//		    }
		    return root;
		}

		class TrieNode {
		    TrieNode[] next = new TrieNode[26];
		    String word;
		}
		
		
		
		
		
		
	}
