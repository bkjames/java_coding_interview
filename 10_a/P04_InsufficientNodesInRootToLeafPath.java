package a_20200813;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}
public class P04_InsufficientNodesInRootToLeafPath {

	public static void main(String[] args) {
		P04_InsufficientNodesInRootToLeafPath a = new P04_InsufficientNodesInRootToLeafPath();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(8);
		root.left.left.right = new TreeNode(9);
		root.left.right = new TreeNode(-99);
		root.left.right.left = new TreeNode(-99);
		root.left.right.right = new TreeNode(-99);
		
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(-99);
		root.right.left.left = new TreeNode(12);
		root.right.left.right = new TreeNode(13);
		root.right.right = new TreeNode(7);
		root.right.right.left = new TreeNode(-99);
		root.right.right.right = new TreeNode(14);
		
		int limit = 1;
		TreeNode node= a.sufficientSubset(root, limit);
//		a.print(node);
		
	}
	public TreeNode sufficientSubset(TreeNode node, int limit) {
	    if (node == null) return null;
	    System.out.println("11node.val "+node.val+" limit "+limit);
	    if (isLeaf(node)) {
	    	System.out.println("22node.val "+node.val+" limit "+limit);
	    	return node.val < limit ? null : node;
	    }

	    node.left = sufficientSubset(node.left, limit - node.val);
	    node.right = sufficientSubset(node.right, limit - node.val);

	    return isLeaf(node) ? null : node;
	}

	private boolean isLeaf(TreeNode node) {
	    return node.left == null && node.right == null;
	}
	
	void print(TreeNode node) {
		while(node != null) {
			System.out.println(node.val);
			print(node.left);
			print(node.right);
		}
	}
	
//	printLeafNodes
	
	
	
	
}
