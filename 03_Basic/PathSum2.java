package a;

import java.util.LinkedList;
import java.util.List;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		this.val = x;
	}
}
public class PathSum2 {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(4);
		node.right = new TreeNode(8);
		node.left.left = new TreeNode(11);
		node.left.left.left = new TreeNode(7);
		node.left.left.right = new TreeNode(2);
		
		node.right.left = new TreeNode(13);
		node.right.right = new TreeNode(4);
		node.right.right.left = new TreeNode(5);
		node.right.right.right = new TreeNode(1);
		System.out.println(pathSum(node, 22));
	}
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum){
		List<List<Integer>> result  = new LinkedList<List<Integer>>();
		List<Integer> currentResult  = new LinkedList<Integer>();
		pathSum(root,sum,currentResult,result);
		return result;
	}

	public static void pathSum(TreeNode root, int sum, List<Integer> currentResult,List<List<Integer>> result) {

		if (root == null)
			return;
		System.out.println(root.val);
		currentResult.add(new Integer(root.val));
		if (root.left == null && root.right == null && sum == root.val) {
			result.add(new LinkedList(currentResult));
			currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
			return;
		} else {
			pathSum(root.left, sum - root.val, currentResult, result);
			pathSum(root.right, sum - root.val, currentResult, result);
		}
		currentResult.remove(currentResult.size() - 1);
	}
}
