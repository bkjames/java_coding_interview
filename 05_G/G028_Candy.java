package p1;

import java.util.*;

public class G028_Candy {

	public static void main(String[] args) {
//		int[] ratings = {1,0,2};
		int[] ratings = {1,2,2};
		G028_Candy a = new G028_Candy();
		System.out.println(a.candy_1(ratings));
//		System.out.println(a.candy_twoArray(ratings));
//		System.out.println(a.candy_brute(ratings));
		
	}
	
	public int candy_1(int[] ratings) {
	    int candies[] = new int[ratings.length];        
	    Arrays.fill(candies, 1);// Give each child 1 candy 
	 // Scan from left to right, to make sure right higher rated child gets 
//	    1 more candy than left lower rated child	
	    for (int i = 1; i < candies.length; i++){
	        if (ratings[i] > ratings[i - 1]) candies[i] = (candies[i - 1] + 1);
	    }
	     
	    for (int i = candies.length - 2; i >= 0; i--) {
	    	// Scan from right to left, 
//	    	to make sure left higher rated child gets 1 more candy than right lower rated child
		    if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
	    }
	    
	    int sum = 0;        
	    for (int candy : candies)  
	    	sum += candy;        
	    return sum;
	}
	
	  public int candy_twoArray(int[] ratings) {
	        int sum = 0;
	        int[] left2right = new int[ratings.length];
	        int[] right2left = new int[ratings.length];
	        Arrays.fill(left2right, 1);
	        Arrays.fill(right2left, 1);
	        for (int i = 1; i < ratings.length; i++) {
	            if (ratings[i] > ratings[i - 1]) {
	                left2right[i] = left2right[i - 1] + 1;
	            }
	        }
	        for (int i = ratings.length - 2; i >= 0; i--) {
	            if (ratings[i] > ratings[i + 1]) {
	                right2left[i] = right2left[i + 1] + 1;
	            }
	        }
	        for (int i = 0; i < ratings.length; i++) {
	            sum += Math.max(left2right[i], right2left[i]);
	        }
	        return sum;
	    }
	
	 public int candy(int[] ratings) {
	        if (ratings == null || ratings.length == 0) return 0;
	        int total = 1, prev = 1, countDown = 0;
	        for (int i = 1; i < ratings.length; i++) {
	            if (ratings[i] >= ratings[i-1]) {
	                if (countDown > 0) {
	                    total += countDown*(countDown+1)/2; // arithmetic progression
	                    if (countDown >= prev) total += countDown - prev + 1;
	                    countDown = 0;
	                    prev = 1;
	                }
	                prev = ratings[i] == ratings[i-1] ? 1 : prev+1;
	                total += prev;
	            } else countDown++;
	        }
	        if (countDown > 0) { // if we were descending at the end
	            total += countDown*(countDown+1)/2;
	            if (countDown >= prev) total += countDown - prev + 1;
	        }
	        return total;
	    }
	 
	 
	    public int candy_brute(int[] ratings) {
	        int[] candies = new int[ratings.length];
	        Arrays.fill(candies, 1);
	        boolean flag = true;
	        int sum = 0;
	        while (flag) {
	            flag = false;
	            for (int i = 0; i < ratings.length; i++) {
	                if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
	                    candies[i] = candies[i + 1] + 1;
	                    flag = true;
	                }
	                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
	                    candies[i] = candies[i - 1] + 1;
	                    flag = true;
	                }
	            }
	        }
	        for (int candy : candies) {
	            sum += candy;
	        }
	        return sum;
	    }
	    
	  
	    
	    public int candy_oneArray(int[] ratings) {
	        int[] candies = new int[ratings.length];
	        Arrays.fill(candies, 1);
	        for (int i = 1; i < ratings.length; i++) {
	            if (ratings[i] > ratings[i - 1]) {
	                candies[i] = candies[i - 1] + 1;
	            }
	        }
	        int sum = candies[ratings.length - 1];
	        for (int i = ratings.length - 2; i >= 0; i--) {
	            if (ratings[i] > ratings[i + 1]) {
	                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
	            }
	            sum += candies[i];
	        }
	        return sum;
	    }
	
	
	

}
