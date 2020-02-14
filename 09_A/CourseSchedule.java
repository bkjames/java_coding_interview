package ama;
import java.util.*;

public class CourseSch {

	public static void main(String[] args) {
		int numCourse= 4;
//		int[][] nums = {{1,0},{0,1}};
//		int[][] nums = {{1,0}};
//		int[][] nums = {{1,0}, {2,1},{1,2}};
		int[][] nums = {{1,0}, {2,1}, {3,2}};
		CourseSch a = new CourseSch();
		System.out.println(a.canFinish_best(numCourse, nums));
		System.out.println(a.canFinish2(numCourse, nums));
	}
	
	public  boolean canFinish_best(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0)
			return false;
		Queue<Integer> queue = new LinkedList<>();
		int[] inDegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			inDegree[prerequisites[i][1]]++;
		}
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int x = queue.poll();
			System.out.println("x:   "+x);
			for (int i = 0; i < prerequisites.length; i++) {
				if (x == prerequisites[i][0]) {
					System.out.println("22x: "+x);
					inDegree[prerequisites[i][1]]--;
					if (inDegree[prerequisites[i][1]] == 0)
						queue.offer(prerequisites[i][1]);
				}
			}
		}
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] != 0)
				return false;
		}
		return true;
	}
	
	public static boolean canFinish_best2(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0)
			return false;
		Queue<Integer> queue = new LinkedList<>();
		int[] inDegree = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			inDegree[prerequisites[i][1]]++;
		}
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int x = queue.poll();
			for (int i = 0; i < prerequisites.length; i++) {
				if (x == prerequisites[i][0]) {
					inDegree[prerequisites[i][1]]--;
					if (inDegree[prerequisites[i][1]] == 0)
						queue.offer(prerequisites[i][1]);
				}
			}
		}
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] != 0)
				return false;
		}
		return true;
	}
	
public boolean canFinish2(int numCourses, int[][] prerequisites){
	    
		int[] incomingEdges = new int[numCourses];
	    List<Integer>[] goCourses = new List[numCourses];
	    for(int i=0;i<goCourses.length;i++){
	        goCourses[i] = new LinkedList<Integer>();
	    }
	    for(int[] pair: prerequisites){
	        incomingEdges[pair[0]]++;
	        goCourses[pair[1]].add(pair[0]);
	    }
	    Queue<Integer> queue = new LinkedList<Integer>();
	    for(int i=0;i<incomingEdges.length;i++){
	        if(incomingEdges[i]==0){
	            queue.add(i);
	        }
	    }
	    int edgeCnt = prerequisites.length;
	    while(!queue.isEmpty()){
	        int cur = queue.poll();
	        for(int goCrs: goCourses[cur]){
	             edgeCnt--;
	             if(--incomingEdges[goCrs]==0)
	                queue.add(goCrs);
	        }
	    }
	    return edgeCnt==0;
	}
	
	
	
	
	
	
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
	    int[][] matrix = new int[numCourses][numCourses]; // i -> j
	    int[] indegree = new int[numCourses];
	    
	    for (int i=0; i<prerequisites.length; i++) {
	        int ready = prerequisites[i][0];
	        int pre = prerequisites[i][1];
	        System.out.println("ready: "+ready+" pre "+pre);
	        if (matrix[pre][ready] == 0)
	            indegree[ready]++; //duplicate case
	        matrix[pre][ready] = 1;
	    }
	    
	    int count = 0;
	    Queue<Integer> queue = new LinkedList();
	    for (int i=0; i<indegree.length; i++) {
	        if (indegree[i] == 0) queue.offer(i);
	    }
	    while (!queue.isEmpty()) {
	        int course = queue.poll();
	        count++;
	        for (int i=0; i<numCourses; i++) {
	            if (matrix[course][i] != 0) {
	                if (--indegree[i] == 0)
	                    queue.offer(i);
	            }
	        }
	    }
	    return count == numCourses;
	}
}
