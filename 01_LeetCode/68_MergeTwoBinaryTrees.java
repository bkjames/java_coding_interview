package code4;



class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}

public class MergeTwoBinaryTrees {
	
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.right = new TreeNode(2);
		t1.left.left = new TreeNode(5);
		
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.right = new TreeNode(3);
		t2.left.right = new TreeNode(4);
		t2.right.right = new TreeNode(7);
		TreeNode node = MergeTrees(t1,t2);
		inorder(node);
	}

	 static void inorder(TreeNode node) 
     { 
         if (node == null) 
             return; 
        
         /* first recur on left child */
         inorder(node.left); 
        
         /* then print the data of node */
         System.out.printf("%d ", node.val); 
        
         /* now recur on right child */
         inorder(node.right); 
     } 
       
     /* Method to merge given two binary trees*/
     static TreeNode MergeTrees(TreeNode t1, TreeNode t2) 
     { 
         if (t1 == null) 
             return t2; 
         if (t2 == null) 
             return t1; 
         t1.val += t2.val; 
         t1.left = MergeTrees(t1.left, t2.left); 
         t1.right = MergeTrees(t1.right, t2.right); 
         return t1; 
     } 
}


package top50;


class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}
public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(3);
		node.right = new TreeNode(2);
		node.left.left = new TreeNode(5);
		
		TreeNode node2= new TreeNode(2);
		node2.left = new TreeNode(1);
		node2.right = new TreeNode(3);
		node2.left.right = new TreeNode(4);
		node2.right.right = new TreeNode(7);
		
		MergeTwoBinaryTrees a = new MergeTwoBinaryTrees();
		a.mergeTrees(node, node2);
		
	}
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		  if (t1 == null) {
		    return t2;
		  }

		  if (t2 != null) {
			System.out.println(t1.val +" "+t2.val);
		    t1.val += t2.val;
		    t1.left = mergeTrees(t1.left, t2.left);
		    t1.right = mergeTrees(t1.right, t2.right);
		    System.out.println("=end==="+t1.val +" "+t2.val);
		  }

		  return t1;
		}
	
	Solution 2: Iterative DFS

	// Method 2: Iterative DFS
	// Time: O(n)
	// Space: O(height)
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	  if (t1 == null) {
	    return t2;
	  }
	  // Use stack to help DFS
	  Deque<TreeNode[]> stack = new LinkedList<>();
	  stack.offerLast(new TreeNode[] {t1, t2});
	  while (!stack.isEmpty()) {
	    TreeNode[] cur = stack.pollLast();
	    // no need to merge t2 into t1
	    if (cur[1] == null) {
	      continue;
	    }
	    // merge t1 and t2
	    cur[0].val += cur[1].val;
	    // if node in t1 == null, use node in t2 instead
	    // else put both nodes in stack to merge
	    if (cur[0].left == null) {
	      cur[0].left = cur[1].left;
	    } else {
	      stack.offerLast(new TreeNode[] {cur[0].left, cur[1].left});
	    }
	    if (cur[0].right == null) {
	      cur[0].right = cur[1].right;
	    } else {
	      stack.offerLast(new TreeNode[] {cur[0].right, cur[1].right});
	    }
	  }
	  return t1;
	}
	Solution 3: Iterative BFS

	// Method 3: Iterative BFS
	// Time: O(n)
	// Space: O(n)
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	  if (t1 == null) {
	    return t2;
	  }
	  // Use stack to help DFS
	  Queue<TreeNode[]> queue = new LinkedList<>();
	  queue.offer(new TreeNode[] {t1, t2});
	  while (!queue.isEmpty()) {
	    TreeNode[] cur = queue.poll();
	    // no need to merge t2 into t1
	    if (cur[1] == null) {
	      continue;
	    }
	    // merge t1 and t2
	    cur[0].val += cur[1].val;
	    // if node in t1 == null, use node in t2 instead
	    // else put both nodes in stack to merge
	    if (cur[0].left == null) {
	      cur[0].left = cur[1].left;
	    } else {
	      queue.offer(new TreeNode[] {cur[0].left, cur[1].left});
	    }
	    if (cur[0].right == null) {
	      cur[0].right = cur[1].right;
	    } else {
	      queue.offer(new TreeNode[] {cur[0].right, cur[1].right});
	    }
	  }
	  return t1;
	}
}

