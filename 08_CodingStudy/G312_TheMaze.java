package p4;
import java.util.*;

public class G312_TheMaze {

	public static void main(String[] args) {
		int[][] maze = {
				{0,0,1,0,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,0,1,1},
				{0,0,0,0,0}
				};
		int[] start = {0,4};
		int[] dest = {4,4};
		G312_TheMaze a = new G312_TheMaze();
		System.out.println(a.hasPath_bfs(maze, start, dest));
	}
	
	
	 class Cell {
	        int x;
	        int y;
	        Cell(int x, int y){
	            this.x=x;
	            this.y=y;
	        }
	    }

	    public boolean hasPath_bfs(int[][] maze, int[] start, int[] destination) {
	        boolean[][] visited = new boolean[maze.length][maze[0].length];
	        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

	        Cell cell = new Cell(start[0], start[1]);
	        Queue<Cell> q = new LinkedList<>();
	        q.add(cell);

	        while (!q.isEmpty()){
	            Cell cur = q.poll();
	            visited[cur.x][cur.y]=true;

	            if(cur.x==destination[0] && cur.y==destination[1]) return true;

	            for(int[] direction : directions) {
	                int newX = cur.x;
	                int newY = cur.y;

	                while(isValid(maze, newX+direction[0], newY+direction[1])){
	                    newX+=direction[0];
	                    newY+=direction[1];
	                }

	                if(!visited[newX][newY]) q.add(new Cell(newX, newY));
	            }
	        }

	        return false;
	    }

	    private boolean isValid(int[][] maze, int x, int y) {
	        return x >= 0 && y >= 0 && x<maze.length && y<maze[0].length && maze[x][y]==0;
	    }
	    
	    
	 class Point {
	        int x,y;
	        public Point(int _x, int _y) {x=_x;y=_y;}
	    }
	    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
	        int m=maze.length, n=maze[0].length;
	        if (start[0]==destination[0] && start[1]==destination[1]) return true;
	        int[][] dir=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
	        boolean[][] visited=new boolean[m][n];
	        LinkedList<Point> list=new LinkedList<>();
	        visited[start[0]][start[1]]=true;
	        list.offer(new Point(start[0], start[1]));
	        while (!list.isEmpty()) {
	            Point p=list.poll();
	            int x=p.x, y=p.y;
	            for (int i=0;i<4;i++) {
	                int xx=x, yy=y;
	                while (xx>=0 && xx<m && yy>=0 && yy<n && maze[xx][yy]==0) {
	                    xx+=dir[i][0];
	                    yy+=dir[i][1];
	                }
	                xx-=dir[i][0];
	                yy-=dir[i][1];
	                if (visited[xx][yy]) continue;
	                visited[xx][yy]=true;
	                if (xx==destination[0] && yy==destination[1]) return true;
	                list.offer(new Point(xx, yy));
	            }
	        }
	        return false;
	        
	    }
	
}
