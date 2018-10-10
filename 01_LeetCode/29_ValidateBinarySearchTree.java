package aExe07;

import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}

public class ValidateBinarySearchTree {

	 public static void main(String[] args) throws Exception
	    {
	        TreeNode root = new TreeNode(20);
	        root.right = new TreeNode(30);
	        root.left = new TreeNode(10);
	        root.left.left = new TreeNode(50);
	        
	        System.out.println(isValidBST(root));

	    }
	 
	 
	 public static boolean isValidBST(TreeNode root) {
	        Stack<TreeNode> stack = new Stack<>();
	        TreeNode pre = null;
	        while (root != null || !stack.isEmpty()) {
	            while (root != null) {
	                stack.push(root);
	                root = root.left;
	            }
	            root = stack.pop();
	            if (pre != null && pre.val >= root.val) {
	                return false;
	            }
	            pre = root;
	            root = root.right;
	        }
	        return true;
	    }
}
