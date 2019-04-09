package zGoo1;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}
public class G010_CountCompleteTreeNodes {

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.left = new TreeNode(4);
		tree.left.right = new TreeNode(5);
		tree.right.left = new TreeNode(6);
		G010_CountCompleteTreeNodes a = new G010_CountCompleteTreeNodes();
		System.out.println(a.countNodes(tree));
	}
	public int countNodes(TreeNode root) {

	    int leftDepth = leftDepth(root);
		int rightDepth = rightDepth(root);

		if (leftDepth == rightDepth)
			return (1 << leftDepth) - 1;
		else
			return 1+countNodes(root.left) + countNodes(root.right);

	}

	private int rightDepth(TreeNode root) {
		// TODO Auto-generated method stub
		int dep = 0;
		while (root != null) {
			System.out.println("right: "+root.val);
			root = root.right;
			dep++;
			System.out.println("===right dep===="+dep);
		}
		System.out.println("===rightDepth=====");
		return dep;
	}

	private int leftDepth(TreeNode root) {
		// TODO Auto-generated method stub
		int dep = 0;
		while (root != null) {
			System.out.println("left: "+root.val);
			root = root.left;
			dep++;
			System.out.println("===left dep===="+dep);
		}
		System.out.println("===leftDepth=====");
		return dep;
	}
}
