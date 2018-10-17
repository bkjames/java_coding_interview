package Tree;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}

public class BinaryTree {
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		
		System.out.println("preorder");
		printPreorder(tree);
		System.out.println("Inorder");
		printInorder(tree);
		System.out.println("Postorder");
		printPostorder(tree);
	}
	
	public static void printPreorder(TreeNode node) {
		if(node == null) return;
		System.out.println(node.val+"");
		printPreorder(node.left);
		printPreorder(node.right);
	}
	
	public static void printInorder(TreeNode node) {
		if(node == null) return;
		printInorder(node.left);
		System.out.println(node.val+"");
		printInorder(node.right);
	}
	
	public static void printPostorder(TreeNode node) {
		if(node==null) return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.println(node.val+"");
		
	}
	
	
}
