package aExe07;

import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}

Question : Binary Tree Inorder Traversal

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    while(root != null || !stack.empty()){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        list.add(root.val);
        root = root.right;
        
    }
    return list;
}
Now, we can use this structure to find the Kth smallest element in BST.

Question : Kth Smallest Element in a BST

 public int kthSmallest(TreeNode root, int k) {
     Stack<TreeNode> stack = new Stack<>();
     while(root != null || !stack.isEmpty()) {
         while(root != null) {
             stack.push(root);    
             root = root.left;   
         } 
         root = stack.pop();
         if(--k == 0) break;
         root = root.right;
     }
     return root.val;
 }
We can also use this structure to solve BST validation question.

Question : Validate Binary Search Tree

public boolean isValidBST(TreeNode root) {
   if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
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
