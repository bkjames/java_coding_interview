package aExe01;

public class NumberOfIsland {
	
	 // Driver method
    public static void main (String[] args) throws java.lang.Exception
    {

                                
     char M[][]=   {{'1', '1', '0', '0', '0'},
                    {'0', '1', '0', '0', '1'},
                    {'1', '0', '0', '1', '1'},
                    {'0', '0', '0', '0', '0'},
                    {'1', '0', '1', '0', '1'}
                                   };
        NumberOfIsland I = new NumberOfIsland();
        System.out.println("Number of islands is: "+ I.numIslands(M));
    }

	
	public int numIslands(char[][] grid) {
	    if(grid==null || grid.length==0||grid[0].length==0)
	        return 0;
	 
	    int m = grid.length;
	    int n = grid[0].length;
	 
	    int count=0;
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            if(grid[i][j]=='1'){
	            	System.out.println("i: "+i+" j:"+j);
	                count++;
	                merge(grid, i, j);
	            }
	        }
	    }
	 
	    return count;
	}
	 
	public void merge(char[][] grid, int i, int j){
	    int m=grid.length;
	    int n=grid[0].length;
	 
	    if(i<0||i>=m||j<0||j>=n||grid[i][j]!='1')
	        return;
	 
	    grid[i][j]='X';
	 
	    merge(grid, i-1, j);
	    merge(grid, i+1, j);
	    merge(grid, i, j-1);
	    merge(grid, i, j+1);
	}

}
