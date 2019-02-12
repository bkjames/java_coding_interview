package easy;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int x){
		this.val = x;
	}
}

public class DiameterOfBinaryTree {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		DiameterOfBinaryTree a = new DiameterOfBinaryTree();
		System.out.println("val: "+a.diameter(node));
	}
	
	int ans ;
	public  int diameter(TreeNode root) {
		ans =1;
		depth(root);
		System.out.println("==========");
		return ans-1;
	}
	
	public  int depth(TreeNode node) {
		if(node== null) return 0;
		System.out.println(node.val);
		
		if(node.left!= null)System.out.println("node.left: "+node.left.val);
		int L = depth(node.left);
		if(node.right!= null)System.out.println("node.right: "+node.right.val);
//		System.out.println("node.right: "+node.right.val);
		int R = depth(node.right);
		ans = Math.max(ans, L+R+1);
		return Math.max(L, R)+1;
	}

}
