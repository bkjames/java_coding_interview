


public class Graph3 {

	public static void main(String[] args) {
        Graph3 g = new Graph3(8);
        g.input(1, 2, 3);
        g.input(1, 5, 4);
        g.input(1, 4, 4);
        g.input(2, 3, 2);
        g.input(3, 4, 1);
        g.input(4, 5, 2);
        g.input(5, 6, 4);
        g.input(4, 7, 6);
        g.input(7, 6, 3);
        g.input(3, 8, 3);
        g.input(6, 8, 2);
        g.dijkstra(1);
    }



	    private int n;           //노드들의 수
	    private int maps[][];    //노드들간의 가중치 저장할 변수
	 
	    public Graph3(int n){
	        this.n = n;
	        maps = new int[n+1][n+1];
	         
	    }
	    public void input(int i,int j,int w){
	        maps[i][j] = w;
	        maps[j][i] = w;
	    }
	 
	    public void dijkstra(int v){
	        int distance[] = new int[n+1];          //최단 거리를 저장할 변수
	        boolean[] check = new boolean[n+1];     //해당 노드를 방문했는지 체크할 변수
	         
	        //distance값 초기화.
	        for(int i=1;i<n+1;i++){
	            distance[i] = Integer.MAX_VALUE;
	        }
	         
	        //시작노드값 초기화.
	        distance[v] =0;
	        check[v] =true;
	         
	        //연결노드 distance갱신
	        for(int i=1;i<n+1;i++){
	        	 System.out.println("before check["+i+"] "+check[i]+" maps["+v+"]["+i+"] "+maps[v][i]);
	            if(!check[i] && maps[v][i] !=0){
	            	System.out.println("after check["+i+"] "+check[i]+" maps["+v+"]["+i+"] "+maps[v][i]);
	                distance[i] = maps[v][i];
	                System.out.println("distance["+i+"] "+distance[i]+" maps["+v+"]["+i+"] "+maps[v][i]);
	                System.out.println("");
	            }
	        }
	         
	         
	        for(int a=0;a<n-1;a++){
	            //원래는 모든 노드가 true될때까지 인데
	            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
	            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
	        	System.out.println("a: "+a);
	            int min=Integer.MAX_VALUE;
	            int min_index=-1;
	             
	            //최소값 찾기
	            for(int i=1;i<n+1;i++){
	                if(!check[i] && distance[i]!=Integer.MAX_VALUE){
	                    if(distance[i]<min ){
	                        min=distance[i];
	                        min_index = i;
	                    }
	                }
	            }
	            System.out.println("min_index: "+min_index);
	            check[min_index] = true;
	            for(int i=1;i<n+1;i++){
	                if(!check[i] && maps[min_index][i]!=0){
	                    if(distance[i]>distance[min_index]+maps[min_index][i]){
	                        distance[i] = distance[min_index]+maps[min_index][i];
	                        System.out.println("sec distance["+i+"] "+distance[i]+" maps["+min_index+"]["+i+"] "+maps[min_index][i]);
	                    }
	                }
	            }
	 
	        }
	         
	        //결과값 출력
	        for(int i=1;i<n+1;i++){
	            System.out.print(distance[i]+" ");
	        }
	        System.out.println("");
	         
	    }

}



//11




import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph_Dijkstra {


	public static void main(String[] args) {
		Graph_Dijkstra g = new Graph_Dijkstra();

    	int[][] flights = {{1,2,3},{1,4,4},{2,3,1},{2,5,2},{3,5,1},{4,5,2}};
//    	int[][] flights = {{1,2,3},{1,5,4},{1,4,4},{2,3,2},{3,4,1},{4,5,2}, {5,6,4},{4,7,6},{7,6,3},{3,8,3},{6,8,2}};
    
    	int[] branch= {4,2,3};
        g.dijkstra(flights, branch);
    }

	public List<Integer> makeMap (int[][] flights) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for(int [] f: flights) {
			int s= f[0], d=f[1], w=f[2];
			
			if(!graph.containsKey(s)) {
				graph.put(s, new ArrayList<>());
			}
			graph.get(s).add(new int[] {d,w});
		}
		List<Integer> list = new ArrayList<>();
		for(Integer key : graph.keySet()) {
			System.out.println("key: "+key);
			list.add(key);
		}
		return list;
	
	}
	   
	 
	    public void dijkstra(int[][] flights, int[] branch){
	    	
	    	
	    	Set<Integer> set = new HashSet<>();
	    	for(int[] f :  flights) {
	    		 set.add(f[0]);
	    		 set.add(f[1]);
			    }
	    	System.out.println("set.size(): "+set.size());
		    int n = set.size();           //노드들의 수
		    System.out.println("n: "+n);
		    int[][]  maps = new int[n+1][n+1];
		    
		    for(int[] f :  flights) {
		    	maps[f[0]][f[1]] =f[2];
		    	maps[f[1]][f[0]] =f[2];
		    }
		    
		    
		
	  
	        
	    
	       
//	       for(int k=0; k<list.size(); k++) {
	        Map<Integer, int[]> map = new HashMap<>();
	         
	        //시작노드값 초기화.
	        Iterator<Integer> iterator = set.iterator();

			while (iterator.hasNext()) {

			      int distance[] = new int[n+1];          //최단 거리를 저장할 변수
			        boolean[] visited = new boolean[n+1];     //해당 노드를 방문했는지 체크할 변수
			         
			        //distance값 초기화.
			        for(int i=1;i<n+1;i++){
			            distance[i] = Integer.MAX_VALUE;
			        }
			Integer v = iterator.next();
			System.out.println("Iterator : "+v);
//			if(v==1) {

			System.out.println(v);


	    	System.out.println("v: "+v);
	        distance[v] =0;
	        visited[v] =true;
	         
	        //연결노드 distance갱신
	        for(int i=1;i<n+1;i++){
	        	System.out.println("! visited["+i+"] "+!visited[i]);
	            if(!visited[i] && maps[v][i] !=0){
	                distance[i] = maps[v][i];
	                System.out.println("distance["+i+"] "+distance[i]+" maps["+v+"]["+i+"] "+maps[v][i]);
	            }
	        }
	         
	         
	        for(int a=0;a<n-1;a++){
	            //원래는 모든 노드가 true될때까지 인데
	            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
	            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
	        	System.out.println("a: "+a);
	            int min=Integer.MAX_VALUE;
	            int min_index=-1;
	             
	            //최소값 찾기
	            for(int i=1;i<n+1;i++){
	            	System.out.println("! visited["+i+"] "+!visited[i]+"  distance["+i+"] "+distance[i]);
	                if(!visited[i] && distance[i]!=Integer.MAX_VALUE){
	                    if(distance[i]<min ){
	                        min=distance[i];
	                        min_index = i;
	                    }
	                }
	            }
	            System.out.println("min_index: "+min_index);
	            visited[min_index] = true;
	            for(int i=1;i<n+1;i++){
	            	System.out.println("! check["+i+"] "+!visited[i]+"  maps["+min_index+"]["+i+"]"+maps[min_index][i]);
	                if(!visited[i] && maps[min_index][i]!=0){
	                    if(distance[i]>distance[min_index]+maps[min_index][i]){
	                        distance[i] = distance[min_index]+maps[min_index][i];
	                        System.out.println("sec distance["+i+"] "+distance[i]+" maps["+min_index+"]["+i+"] "+maps[min_index][i]);
	                    }
	                }
	            }
	 
	        }
//				}
			map.put(v, distance);
			
			}
//	       }
	         
	        //결과값 출력
//	        for(int i=1;i<n+1;i++){
//	            System.out.print(distance[i]+" ");
//	        }
//	        
	        for(Integer key : map.keySet()) {
	        	 System.out.println("key "+key+" value: "+map.get(key).length);
	        	 int[] result = map.get(key);
	        	 for(int i : result) {
	        		 System.out.println("val: "+i);
	        	 }
	        }
	       
	         
	    }

}

