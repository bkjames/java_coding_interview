package coding;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}


public class LowestCommonAncestor {
	static int count =0;
	
	public static void main(String[] args) {
//		TreeNode tree = new TreeNode(3);
//		tree.left = new TreeNode(5);
//		tree.right = new TreeNode(1);
//		tree.right.left = new TreeNode(0);
//		tree.right.right = new TreeNode(8);
//		tree.left.left = new TreeNode(6);
//		tree.left.right = new TreeNode(2);
//		tree.left.right.left = new TreeNode(7);
//		tree.left.right.right = new TreeNode(4);
//		TreeNode node = lowestCommonAncestor(tree, tree.left, tree.left.right.right);
//		print(node);
		
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		tree.left.right.left = new TreeNode(7);
		tree.left.right.right = new TreeNode(8);
		TreeNode node = lowestCommonAncestor(tree, tree.left.left, tree.left.right.right );
		System.out.println("$$$$$$$$$$");
		System.out.println(print(node));
		
	}
	
	
	
	public static int print(TreeNode node) {
		if(node !=null) {
			return node.val;
		}else {
			return 0;
		}
	}
	

		
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		System.out.println("start: "+count);
		count++;
	    if(root==null)
	        return null;
	 
	    if(root==p || root==q)
	        return root;
	   
	    TreeNode l = lowestCommonAncestor(root.left, p, q);
	    System.out.println("======left=======");
	    System.out.println(print(l));
	    TreeNode r = lowestCommonAncestor(root.right, p, q);
	    System.out.println("=======right======");
	    System.out.println(print(r));
	 
	    if(l!=null&&r!=null){
	    	 System.out.println("*find*");
	    	 System.out.println(print(l));
	    	 System.out.println(print(r));
	    	 System.out.println(print(root));
	        return root;
	    }else if(l==null&&r==null){
	        return null;
	    }else{
	        return l==null?r:l;
	    }
	}
	
}
