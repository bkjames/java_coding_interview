package p2;
import java.util.*;
public class G136_CourseSchedule2 {

	public static void main(String[] args) {
		
		int numCourses= 4;
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		int[] res = findOrder(numCourses, prerequisites);
		for(int r: res)
			System.out.println(r);
		
	}
	public static int[] findOrder(int numCourses, int[][] prerequisites) { 
	    if (numCourses == 0) return null;
	    // Convert graph presentation from edges to indegree of adjacent list.
	    int indegree[] = new int[numCourses];
	    int order[] = new int[numCourses];
	    int index = 0;
	    for (int i = 0; i < prerequisites.length; i++) // Indegree - how many prerequisites are needed.
	        indegree[prerequisites[i][0]]++;    

	    Queue<Integer> queue = new LinkedList<Integer>();
	    for (int i = 0; i < numCourses; i++) 
	        if (indegree[i] == 0) {
	            // Add the course to the order because it has no prerequisites.
	            order[index++] = i;
	            queue.offer(i);
	        }

	    // How many courses don't need prerequisites. 
	    while (!queue.isEmpty()) {
	        int prerequisite = queue.poll(); // Already finished this prerequisite course.
	        for (int i = 0; i < prerequisites.length; i++)  {
	        	System.out.println("prerequisites["+i+"][1]"+prerequisites[i][1] );
	            if (prerequisites[i][1] == prerequisite) {
	            	System.out.println("prerequisites["+i+"][1]"+prerequisites[i][1]+" prerequisite: "+prerequisite );
	                indegree[prerequisites[i][0]]--; 
	                if (indegree[prerequisites[i][0]] == 0) {
	                    // If indegree is zero, then add the course to the order.
	                    order[index++] = prerequisites[i][0];
	                    queue.offer(prerequisites[i][0]);
	                }
	            } 
	        }
	    }

	    return (index == numCourses) ? order : new int[0];
	}
}
