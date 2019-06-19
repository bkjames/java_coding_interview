package Top50_1;

import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val =x;
	}
}

public class Dfs {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(3);
		tree.left = new TreeNode(9);
		tree.right = new TreeNode(20);
	    tree.right.left = new TreeNode(15);
		tree.right.right = new TreeNode(7);
		Dfs a = new Dfs();
		System.out.println(a.maxDepth(tree));
	}
	
	public int maxDepth(TreeNode root) {
	    if(root == null) {
	        return 0;
	    }
	    
	    Stack<TreeNode> stack = new Stack<>();
	    Stack<Integer> value = new Stack<>();
	    stack.push(root);
	    value.push(1);
	    int max = 0;
	    while(!stack.isEmpty()) {
	        TreeNode node = stack.pop();
	        int count = value.pop();
	        max = Math.max(count, max);
	        if(node.left != null) {
	            stack.push(node.left);
	            value.push(count+1);
	        }
	        if(node.right != null) {
	            stack.push(node.right);
	            value.push(count+1);
	        }
	    }
	    return max;
	}
  
  public int maxDepth(TreeNode root) {
	    if(root == null) {
	        return 0;
	    }
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);
	    int count = 0;
	    while(!queue.isEmpty()) {
	        int size = queue.size();
	        while(size-- > 0) {
	            TreeNode node = queue.poll();
	            if(node.left != null) {
	                queue.offer(node.left);
	            }
	            if(node.right != null) {
	                queue.offer(node.right);
	            }
	        }
	        count++;
	    }
	    return count;
	}
}
