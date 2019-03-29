package real;

import java.util.*;

public class K2017_ColoringBook {
	
	public static int[] solution2(int m, int n, int[][] picture) {
	    int[] answer = new int[2];
	    boolean[][] visited = new boolean[m][n];
	 
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if(picture[i][j] > 0) {
	            	System.out.println("picture["+i+"]["+j+"] "+picture[i][j]);
	                int count = findSpace(visited, picture, picture[i][j] , i, j);
	                answer[0] = count > 0 ? answer[0] + 1 : answer[0];
	                answer[1] = Math.max(count, answer[1]);
	            }
	        }
	    }
	 
	    return answer;
	}
	 
	public static int findSpace(boolean[][] visited, int[][] picture, int value, int i, int j) {
	    if(i < 0 || i >= picture.length || j < 0 || j >= picture[0].length || visited[i][j] == true || value != picture[i][j]) {
	        return 0;
	    } else {
	        visited[i][j] = true;
	        return 1 + findSpace(visited, picture, value, i - 1, j)
	                 + findSpace(visited, picture, value, i + 1, j)
	                 + findSpace(visited, picture, value, i, j - 1)
	                 + findSpace(visited, picture, value, i, j + 1);
	    }
	}


		
		public static void main(String[] args) {
			int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}} ;
			int m =6;
			int n = 4;
			K2017_ColoringBook a = new K2017_ColoringBook();
			int[] result = a.solution2(m,n ,picture);
			for(int r : result)
				System.out.println("r: "+r);
		}

		public static int[] solution(int m, int n, int[][] picture) {
		    int[] answer = new int[2];
		    boolean[][] visited = new boolean[m][n];
		    Stack<Integer> stackX = new Stack<>();
		    Stack<Integer> stackY = new Stack<>();
		    for (int i = 0; i < m; i++) {
		        for (int j = 0; j < n; j++) {
		            int count = 0;
		            if(picture[i][j] > 0 && visited[i][j] == false) {
		                plus(stackX, stackY, visited, j, i);
		                count++;
		                answer[0]++;
		            }
		            while(!stackX.isEmpty()) {
		                int x = stackX.pop();
		                int y = stackY.pop();
		                System.out.println("X: "+x+" Y: "+y);
		                // 위 이동
		                if(y > 0 && picture[y - 1][x] == picture[i][j] && visited[y - 1][x] == false) {
		                    plus(stackX, stackY, visited, x, y - 1);
		                    count++;
		                }
		                // 좌측 이동
		                if(x > 0 && picture[y][x - 1] == picture[i][j] && visited[y][x - 1] == false) {
		                    plus(stackX, stackY, visited, x - 1, y);
		                    count++;
		                }
		                // 아래 이동
		                if(y < m - 1 && picture[y + 1][x] == picture[i][j] && visited[y + 1][x] == false) {
		                    plus(stackX, stackY, visited, x, y + 1);
		                    count++;
		                }
		                // 우측 이동
		                if(x < n - 1 && picture[y][x + 1] == picture[i][j] && visited[y][x + 1] == false) {
		                    plus(stackX, stackY, visited, x + 1, y);
		                    count++;
		                }
		            }
		            answer[1] = Math.max(answer[1], count);
		        }
		    }
		 
		    return answer;
		}
		 
		public static void plus(Stack<Integer> stackX, Stack<Integer> stackY, boolean[][] visited, int j, int i) {
		    stackX.add(j);
		    stackY.add(i);
		    visited[i][j] = true;
		}

	

}
