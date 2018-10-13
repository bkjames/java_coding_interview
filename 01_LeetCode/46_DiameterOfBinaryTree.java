package coding;


class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}
public class DiameterOfBinaryTree {
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		
		DiameterOfBinaryTree d = new DiameterOfBinaryTree();
		System.out.println("Diameter of Tree: " + d.Diameter(tree));
	}
	
	
	public int getHeight(TreeNode root) {
		if (root != null) {
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
		return 0;
	}

	public int Diameter(TreeNode root) {
		if (root != null) {
			// get the left and right subtree height
			int leftH = getHeight(root.left);
			int rightH = getHeight(root.right);

			// get the left diameter and right diameter recursively.
			int leftDiameter = Diameter(root.left);
			int rightDiameter = Diameter(root.right);

			// get the max leftsubtree, rightsubtree, longest path goes through
			// root.
			return getMax(leftH + rightH + 1, leftDiameter, rightDiameter);
		}
		return 0;
	}

	public int getMax(int a, int b, int c) {
		return Math.max(a, Math.max(b, c));
	}

}
