package code04;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(2);
		tree.left.left = new TreeNode(3);
		tree.left.right = new TreeNode(4);
		tree.right.left = new TreeNode(4);
		tree.right.right = new TreeNode(3);
		System.out.println(isSymmetric(tree));
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}
	 
	public static boolean isSymmetric(TreeNode l, TreeNode r) {
		if (l == null && r == null) {
			return true;
		} else if (r == null || l == null) {
			return false;
		}
	 
		if (l.val != r.val)
			return false;
	 
		if (!isSymmetric(l.left, r.right))
			return false;
		if (!isSymmetric(l.right, r.left))
			return false;
	 
		return true;
	}
}
