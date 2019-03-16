package real;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Node{
	int id;
	int x, y;
	Node left, right;
	Node(int id, int x, int y){
		this.id = id;
		this.x = x;
		this.y= y;
	}
}

public class K2018_FindRoad {
	
	public static void main(String[] args) {
		int[][] nodeInfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		K2018_FindRoad a = new K2018_FindRoad();
		int[][] result = a.solution(nodeInfo);
		a.print(result);
	}
	
	public void print(int[][] result) {
		
		int m = result.length;
		int n = result[0].length;
		for(int i=0; i< m ; i++) {
			for(int j=0; j<n; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		
		
	}

	List<Node> nodes = new ArrayList<Node>();
	int idx =0;
	Comparator<Node> Comp = new Comparator<Node>() {
		public int compare(Node a, Node b) {
			if(a.y == b.y) 
				return a.x -b.x;
			return b.y -a.y;	
		}
	};
	
	void addNode(Node parent, Node child) {
		if(child.x < parent.x) {
			if(parent.left == null)
				parent.left = child;
			else
				addNode(parent.left, child);
		}else {
			if(parent.right== null)
				parent.right =child;
			else
				addNode(parent.right, child);
		}
	}
	
	public int[][] solution(int[][] nodeInfo){
		int size = nodeInfo.length;
		for(int i=0; i< size; ++i) {
			nodes.add(new Node(i+1, nodeInfo[i][0], nodeInfo[i][1]));
		}
		nodes.sort(Comp);
		Node root = nodes.get(0); 
		for(int i =1; i< size; ++i) {
			addNode(root, nodes.get(i));
		}
		
		int[][] answer = new int[2][size];
		preorder(answer, root);
		idx =0;
		postorder(answer, root);
		return answer;
	}
	
	void preorder(int[][] answer, Node node) {
		if(node == null) return;
		answer[0][idx++] = node.id;
		preorder(answer, node.left);
		preorder(answer, node.right);
	}
	
	void postorder(int[][] answer, Node node) {
		if(node == null) return;
//		answer[0][idx++] = node.id;
		postorder(answer, node.left);
		postorder(answer, node.right);
		answer[1][idx++]= node.id;
	}
	
	
	
}
