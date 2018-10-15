package code04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val =x;
	}
}

public class BinaryTreeLevelOrderTraversal {
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(20);
		tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);
		System.out.println(levelOrder1(tree));
//		System.out.println(levelOrder2(tree));
		ArrayList<ArrayList<Integer>> result = levelOrder(tree);
		print(result);
	}
	
	
	  //1 queue
	    public static ArrayList<ArrayList<Integer>> levelOrder1(TreeNode root) {
	        // write your code here
	        ArrayList<ArrayList<Integer>> rst = new ArrayList();
	                
	        if (root == null) {
	            return rst;
	        }
	        
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        queue.offer(root);
	        
	        while (!queue.isEmpty()) {
	            int size = queue.size();
	            ArrayList<Integer> level = new ArrayList<Integer>();
	            for (int i = 0; i < size; i++) {
	                TreeNode node = queue.poll();
	                level.add(node.val);
	                if (node.left != null) {
	                    queue.offer(node.left);
	                }
	                if (node.right != null) {
	                    queue.offer(node.right);
	                }
	            }
	            rst.add(level);
	        }
	        
	        return rst;
	    }
	    
	    
		public static void print(ArrayList<ArrayList<Integer>> result) {
			for(ArrayList<Integer> list : result) {
				for(Integer val : list) {
					System.out.println(val);
				}
			}
		}


	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
	    ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> nodeValues = new ArrayList<Integer>();
	    if(root == null)
	        return al;
	 
	    LinkedList<TreeNode> current = new LinkedList<TreeNode>();
	    LinkedList<TreeNode> next = new LinkedList<TreeNode>();
	    current.add(root);
	 
	    while(!current.isEmpty()){
	        TreeNode node = current.remove();
	 
	        if(node.left != null)
	            next.add(node.left);
	        if(node.right != null)
	            next.add(node.right);
	 
	        nodeValues.add(node.val);
	        if(current.isEmpty()){
	            current = next;
	            next = new LinkedList<TreeNode>();
	            al.add(nodeValues);
	            nodeValues = new ArrayList();
	        }
	 
	    }
	    return al;
	}
	
	
	public static ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {

	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>(); 
	    if(root == null) return result;
	    Queue q1 = new LinkedList();
	    Queue q2 = new LinkedList();

	    ArrayList<Integer> list = new ArrayList<Integer>();
	    q1.add(root);

	    while(!q1.isEmpty() || !q2.isEmpty()){

	        while(!q1.isEmpty()){
	            TreeNode temp = (TreeNode)q1.poll();
	            list.add(temp.val);
	            if(temp.left != null) q2.add(temp.left);
	            if(temp.right != null) q2.add(temp.right);
	        }
	        if(list.size() > 0)result.add(new ArrayList<Integer>(list));
	        list.clear();
	        while(!q2.isEmpty()){
	            TreeNode temp = (TreeNode)q2.poll();
	            list.add(temp.val);
	            if(temp.left != null) q1.add(temp.left);
	            if(temp.right != null) q1.add(temp.right);
	        }
	        if(list.size() > 0)result.add(new ArrayList<Integer>(list));
	        list.clear();
	    }
	    return result;
	}
}
