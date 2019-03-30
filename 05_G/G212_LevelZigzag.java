package zGoo1;

import java.util.*;

public class LevelZigzag {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		node.right.right.left = new TreeNode(30);
		node.right.right.right = new TreeNode(40);
		System.out.println(zigzagLevelOrder(node));
	}
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<>();
	    if (root == null) {
	        return result;
	    }
	    
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    boolean reverse = false;
	    
	    while (!queue.isEmpty()) {
	        int size = queue.size();

	        /* use linkedlist to control time complexity of addFirst to O(1) */
	        LinkedList<Integer> tempList = new LinkedList<>();
	        for (int i = 0; i < size; i++) {
	            TreeNode curNode = queue.poll();
	            System.out.println("val: "+curNode.val+" reverse: "+reverse);
	            if (reverse) {
	                tempList.addFirst(curNode.val);
	            }
	            else {
	                tempList.add(curNode.val);
	            }
	            
	            if (curNode.left != null) {
	                queue.offer(curNode.left);
	            }
	            if (curNode.right != null) {
	                queue.offer(curNode.right);
	            }
	        }
	        result.add(tempList);
	        reverse = !reverse;
	    }
	    return result;
	}

}
