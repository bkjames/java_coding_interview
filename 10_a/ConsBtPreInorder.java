package ama002;

import java.util.HashMap;

import ama002.TreeNode;
import java.util.*;

public class ConsBtPreInorder {

	public static void main(String[] args) {
		ConsBtPreInorder a = new ConsBtPreInorder();
		int[] preorder = { 3, 9, 20, 15, 7 };
		int[] inorder = { 9, 3, 15, 20, 7 };
		TreeNode tree = a.buildTree(preorder, inorder);

//		while(tree != null) {
//			System.out.println(tree.val);
////			if (tree.left != null) {
////				tree
////			}
//		}
	}

//	Construct Binary Tree from Preorder and Inorder Traversal

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return helper(preorder, inorder, 0, 0, inorder.length - 1);
	}

	TreeNode helper(int[] preorder, int[] inorder, int preorderPos, int inorderStart, int inorderEnd) {
		if (preorderPos > preorder.length - 1 || inorderStart > inorderEnd)
			return null;
		System.out.println("preorderPos: "+preorderPos);
		TreeNode node = new TreeNode(preorder[preorderPos]);
		System.out.println("node.val "+node.val);
		int pipos = 0;
		for (int i = inorderStart; i <= inorderEnd; i++) {
			if (inorder[i] == preorder[preorderPos]) {
				pipos = i;
			    System.out.println("pipos: "+pipos);
			}
		}
		node.left = helper (preorder, inorder, preorderPos + 1,                             inorderStart,  pipos - 1);
		node.right = helper(preorder, inorder, preorderPos + 1 + pipos - inorderStart,      pipos + 1,     inorderEnd);
		return node;
	}
	

	
	


//	Construct Binary Tree from Inorder and Postorder Traversal
//
//    public TreeNode buildTree(int[] inorder, int[] postorder) {
//      return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);    
//    }
//    
//    TreeNode helper(int[] inorder, int[] postorder, int ppos, int is, int ie){
//      if(ppos >= postorder.length || is > ie) return null;
//      TreeNode node = new TreeNode(postorder[ppos]);
//      int pii = 0;
//      for(int i = 0; i < inorder.length; i++){
//        if(inorder[i] == postorder[ppos]) pii = i;  
//      }
//      node.left = helper(inorder, postorder, ppos - 1 - ie + pii, is, pii - 1);
//      node.right = helper(inorder, postorder, ppos - 1 , pii + 1, ie);
//      return node;
//    }

//	int pre_idx = 0;
//	int[] preorder;
//	int[] inorder;
//	HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();
//
//	private TreeNode buildTree(int[] preorder, int[] inorder) {
//		this.preorder = preorder;
//		this.inorder = inorder;
//
//		// build a hashmap value -> its index
//		int idx = 0;
//		for (Integer val : inorder)
//			idx_map.put(val, idx++);
//		return helper(0, inorder.length);
//
//	}
//
//	public TreeNode helper(int in_left, int in_right) {
//		// if there is no elements to construct subtrees
//		if (in_left == in_right)
//			return null;
//
//		// pick up pre_idx element as a root
//		int root_val = preorder[pre_idx];
//		System.out.println("root_val: "+root_val);
//		TreeNode root = new TreeNode(root_val);
//
//		// root splits inorder list
//		// into left and right subtrees
//		int index = idx_map.get(root_val);
//
//		// recursion
//		pre_idx++;
//		// build left subtree
//		root.left = helper(in_left, index);
//		// build right subtree
//		root.right = helper(index + 1, in_right);
//		return root;
//	}

}
