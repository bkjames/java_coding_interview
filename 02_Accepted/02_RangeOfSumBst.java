
class TreeNode{

	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		this.val =x;
	}
}

public class RangeOfSumBst {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.right = new TreeNode(15);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(7);
		node.right.right = new TreeNode(18);
		System.out.println(rangeSumBST(node, 7,15));
	}
	
    static int sum = 0;
    public static int rangeSumBST(TreeNode root, int L, int R) {
        helper(root, L, R);
        return sum;
    }
    
    public static void helper(TreeNode root, int L, int R){
        if(root == null){
            return;
        }
        if(root.val <= R && root.val >= L){
            sum += root.val;
            helper(root.left, L, R);
            helper(root.right, L, R);
        }else if(root.val < L){
            helper(root.right, L, R); //no need to go left since the left branch must be smaller than L
        }else{ //root great than R
            helper(root.left, L, R); //no need to go right since the right branch must be larger than R
        }
    
	}
}
