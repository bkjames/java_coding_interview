package test;

import java.util.Arrays;

public class CoinChange {

	
	public static void main(String[] args) {
		int[] coins = {1, 2, 5};
		int amount = 11;
		System.out.println(coinChange(coins, amount));
	}
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;             
        int[] dp = new int[amount + 1];  
        Arrays.fill(dp, max);  
        dp[0] = 0;   
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
            	System.out.println("aa: "+coins[j]+"  "+i);
                if (coins[j] <= i) {
                	System.out.println("dp[i] Value: "+dp[i]+" "+coins[j]+" "+i+" dp[i]: "+dp[i]+"   "+dp[i - coins[j]] + 1);
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
