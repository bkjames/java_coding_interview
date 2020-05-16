package Basic;

import java.util.ArrayList;
import java.util.List;


public class ConvertArray2dToList {


		public static void main(String[] args) {
			ConvertArray2dToList a = new ConvertArray2dToList();
			int n = 5;
			int[][] edges = { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 1, 4 }, { 4, 5 } };

			List val = a.convertList(edges);
			System.out.println(val);
			System.out.println("====");
//			System.out.println();
			a.print(a.convertArray(val));
		}
		public List<List<Integer>> convertList(int[][] edges){
			
			List<List<Integer>>  res = new ArrayList<>();
			
			for(int i=0; i<edges.length; i++) {
				List<Integer>  list = new ArrayList<>();
				for(int j=0; j<edges[i].length; j++) {
					list.add(edges[i][j]);
				}
				res.add(list);
			}
			return res;
			
		}
		
		
		public  int[][] convertArray(List<List<Integer>> list) {
			int[][] array = new int[list.size()][];
			for (int i = 0; i < array.length; i++) {
				array[i] = new int[list.get(i).size()];
			}
			for(int i=0; i<list.size(); i++){
				for (int j = 0; j < list.get(i).size(); j++) {
					array[i][j] = list.get(i).get(j);
				}
			}
			return array;
		}
		
		public void print(int[][] result) {
			
			int size = result.length;
			for(int i=0; i<size; i++) {
//				System.out.println(i);
				for(int j=0; j<result[i].length; j++) {
					System.out.println(result[i][j]);
				}
				System.out.println();
			}
		}
		
}
