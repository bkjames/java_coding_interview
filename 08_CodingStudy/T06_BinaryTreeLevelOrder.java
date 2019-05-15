package part1;

import java.util.*;

class TreeNode{
	int val ;
	TreeNode left, right;
	TreeNode(int x){
		this.val =x;
	}
}
public class BinaryTreeLevelOrder {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		tree.left.left = new TreeNode(8);
		tree.left.right = new TreeNode(10);
		tree.right = new TreeNode(20);
		tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);
		System.out.println(solve(tree));
	}
	public static List<List<Integer>> solve(TreeNode tree) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(tree);
		int queueSize = 0;
		while(!queue.isEmpty()) {
			  List<Integer> levelList = new ArrayList<>();
			  queueSize = queue.size();
			  System.out.println("queueSize: "+queueSize);
			  for(int i=0; i<queueSize; i++) {
				  TreeNode levelNode = queue.poll();
				  levelList.add(levelNode.val);
				  if(levelNode.left != null) {
					  queue.offer(levelNode.left);
				  }
				  if(levelNode.right != null) {
					  queue.offer(levelNode.right);
				  }
			  }
			  result.add(levelList);
		}
		return result;
	}
}
