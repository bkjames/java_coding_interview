package zGTop;

import java.util.*;

public class GT_OptimalAccountBalancing {

	public static void main(String[] args) {
		GT_OptimalAccountBalancing a = new GT_OptimalAccountBalancing();
//		int[][] transactions = { { 0, 1, 10 }, 
//				                 { 1, 0, 1 },
//				                 { 1, 2, 5 },
//				                 { 2, 0, 5 } };

		int[][] transactions = { { 0, 1, 10 }, { 2, 0, 5 } };
//		System.out.println(a.minTransfers(transactions));
		System.out.println(a.minTransfers_map(transactions));

	}

	public int minTransfers_best(int[][] transactions) {
		Map<Integer, Long> map = new HashMap();
		for (int[] t : transactions) {
			long val1 = map.getOrDefault(t[0], 0L);
			long val2 = map.getOrDefault(t[1], 0L);
			map.put(t[0], val1 - t[2]);
			map.put(t[1], val2 + t[2]);
		}

		List<Long> list = new ArrayList();
		for (long val : map.values()) {
			if (val != 0)
				list.add(val);
		}

		Long[] debts = new Long[list.size()];
		debts = list.toArray(debts);
		return helper(debts, 0, 0);
	}

	int helper(Long[] debts, int pos, int count) {
		while (pos < debts.length && debts[pos] == 0)
			pos++;
		int res = Integer.MAX_VALUE;
		long pre = 0;
		for (int i = pos + 1; i < debts.length; i++) {
			if (debts[i] != pre && debts[pos] * debts[i] < 0) {
				debts[i] += debts[pos];
				res = Math.min(res, helper(debts, pos + 1, count + 1));
				debts[i] = debts[i] - debts[pos];
				pre = debts[i];
			}
		}
		return res == Integer.MAX_VALUE ? count : res;
	}

	static int min = Integer.MAX_VALUE;

	public int minTransfers_map(int[][] transactions) {
		min = Integer.MAX_VALUE;
		HashMap<Integer, Integer> profitMap = new HashMap<>();
		for (int[] trans : transactions) {
			int a = trans[2];
			profitMap.put(trans[0], profitMap.getOrDefault(trans[0], 0) + a);
			profitMap.put(trans[1], profitMap.getOrDefault(trans[1], 0) - a);
		}
		LinkedList<Integer> positive = new LinkedList<>();
		LinkedList<Integer> negative = new LinkedList<>();
		for (Integer key : profitMap.keySet()) {
			Integer val = profitMap.get(key);
			if (val > 0) {
				positive.add(val);
			} else if (val < 0) {
				negative.add(val);
			}
		}
		dfs(positive, negative, 0);
		return min;
	}

	public void dfs(List<Integer> positive, List<Integer> negative, int count) {
		if (positive.size() == 0 && negative.size() == 0) {
			min = Math.min(count, min);
			return;
		}
		if (count >= min) {
			return;
		}
		int positiveVal = positive.get(0);

		// We start will different negative values and use
		for (int j = 0; j < negative.size(); j++) {
			int negativeVal = negative.get(j);
			// Deduct the balance. If the new values become zero then we remove those values
			// from the list.
			int newPositiveVal = Math.max(positiveVal + negativeVal, 0);
			int newNegativeVal = Math.min(0, positiveVal + negativeVal);
			if (newPositiveVal == 0) {
				positive.remove(0);
			} else {
				positive.set(0, newPositiveVal);
			}
			if (newNegativeVal == 0) {
				negative.remove(j);
			} else {
				negative.set(j, newNegativeVal);
			}

			dfs(positive, negative, count + 1);

			// Backtrack, we need to add back the values.
			if (newPositiveVal == 0) {
				positive.add(0, positiveVal);
			} else {
				positive.set(0, positiveVal);
			}
			if (newNegativeVal == 0) {
				negative.add(j, negativeVal);
			} else {
				negative.set(j, negativeVal);
			}
		}
	}

}
