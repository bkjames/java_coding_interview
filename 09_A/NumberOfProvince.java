package zTest0203;

public class NumberOfProvince {

	public static void main(String[] args) {
		int[][] isConnected = { { 1, 1, 0 }, 
				                { 1, 1, 0 }, 
				                { 0, 0, 1 } };
		NumberOfProvince a = new NumberOfProvince(3);
		System.out.println(a.findCircleNum(isConnected));

	}

	public int findCircleNum(int[][] M) {
		int n = M.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (M[i][j] == 1)
					union(i, j);
			}
		}
		return count();
	}

	private int count = 0;
	private int[] parent, rank;

	public NumberOfProvince(int n) {
		count = n;
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}

	public int find(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]]; // path compression by halving
			p = parent[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ)
			return;
		if (rank[rootQ] > rank[rootP]) {
			parent[rootP] = rootQ;
		} else {
			parent[rootQ] = rootP;
			if (rank[rootP] == rank[rootQ]) {
				rank[rootP]++;
			}
		}
		count--;
	}

	public int count() {
		return count;
	}

}
