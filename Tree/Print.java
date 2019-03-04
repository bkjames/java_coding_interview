  private static TreeNode buildTree(Deque<String> nodes) {
	        String val = nodes.remove();
	        if (val.equals(NN)) return null;
	        else {
	            TreeNode node = new TreeNode(Integer.valueOf(val));
	            node.left = buildTree(nodes);
	            node.right = buildTree(nodes);
	            return node;
	        }
	    }
	    
		public static void printLeafNodes(TreeNode node) {
		    // base case
		    if (node == null) {
		      return;
		    }

		    if (node.left == null && node.right == null) {
		      System.out.printf("%d ", node.val);
		    }

		    printLeafNodes(node.left);
		    printLeafNodes(node.right);
		  }
