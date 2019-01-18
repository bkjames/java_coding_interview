package Array;

import java.util.ArrayList;

public List<Integer> spiralOrder2(int[][] matrix) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        
        return res;
    }


public class SpiralMatrix {
	
		public static void main(String[] args) {
			
			SpiralMatrix s = new SpiralMatrix();
			
			int[][] matrix = {{1,2,3},{4,5,6,},{7,8,9}};
			System.out.println(s.spiralOrder(matrix));
		}

	    public ArrayList<Integer> spiralOrder(int[][] matrix) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	 
	        if(matrix == null || matrix.length == 0) return result;
	 
	        int m = matrix.length;
	        int n = matrix[0].length;
	 
	        int x=0; 
	        int y=0;
	 
	        while(m>0 && n>0){
	 
	            //if one row/column left, no circle can be formed
	            if(m==1){
	                for(int i=0; i<n; i++){
	                    result.add(matrix[x][y++]);
	                }
	                break;
	            }else if(n==1){
	                for(int i=0; i<m; i++){
	                    result.add(matrix[x++][y]);
	                }
	                break;
	            }
	 
	            //below, process a circle
	 
	            //top - move right
	            for(int i=0;i<n-1;i++){
	                result.add(matrix[x][y++]);
	            }
	 
	            //right - move down
	            for(int i=0;i<m-1;i++){
	                result.add(matrix[x++][y]);
	            }
	 
	            //bottom - move left
	            for(int i=0;i<n-1;i++){
	                result.add(matrix[x][y--]);
	            }
	 
	            //left - move up
	            for(int i=0;i<m-1;i++){
	                result.add(matrix[x--][y]);
	            }
	 
	            x++;
	            y++;
	            m=m-2;
	            n=n-2;
	        }
	 
	        return result;
	    }
	}
