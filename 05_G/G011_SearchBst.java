package Problems;

public class G011_SearchBst {

	 public TreeNode searchBST(TreeNode root, int val) {
	        if (root == null)
	            return root;
	        if (root.val == val)
	            return root;
	        else if (root.val > val)
	            return searchBST(root.left, val);
	        else if (root.val < val)
	            return searchBST(root.right, val);
	        return null;
	    }
}
