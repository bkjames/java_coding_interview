package coding;

import java.util.Stack;

public class MaximalRectangle {
	public static void main (String[] args)  
    { 
        int R = 4; 
        int C = 4; 
  
        char A[][] = { 
        		      {'1', '0', '1', '0','0'}, 
                      {'1', '0', '1', '1','1'}, 
                      {'1', '1', '1', '1','1'},
                      {'1', '0', '0', '1','0'}, 
                    }; 
        System.out.print("Area of maximum rectangle is " +  maximalRectangle(A)); 
    } 
	
	public static void print(int[][] T) {
		int m = T.length;
		int n = T[0].length;
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++) {
				System.out.print(T[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		int n = m == 0 ? 0 : matrix[0].length;
		int[][] height = new int[m][n + 1];
	 
		int maxArea = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') {
					height[i][j] = 0;
				} else {
					height[i][j] = i == 0 ? 1 : height[i - 1][j] + 1;
				}
			}
		}
		print(height);
	 
		for (int i = 0; i < m; i++) {
			System.out.println("height[i]: "+height[i].length);
			int area = maxAreaInHist(height[i]);
			System.out.println("area: "+area);
			if (area > maxArea) {
				maxArea = area;
			}
		}
	 
		return maxArea;
	}
	 
	private static int maxAreaInHist(int[] height) {
		Stack<Integer> stack = new Stack<Integer>();
	 
		int i = 0;
		int max = 0;
	 
		while (i < height.length) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				System.out.println("i: "+i);
				stack.push(i++);
			} else {
				int t = stack.pop();
				System.out.println("pop: "+t);
				max = Math.max(max, height[t]* (stack.isEmpty() ? i : i - stack.peek() - 1));
				System.out.println("max: "+max);
			}
		}
	 
		return max;
	}

}
