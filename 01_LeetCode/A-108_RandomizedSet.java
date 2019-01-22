

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
	
	public static void main(String[] args) {
	
		 RandomizedSet obj = new RandomizedSet();
		 boolean param_1 = obj.insert(10);
		 System.out.println(param_1);
		 boolean param_2 = obj.remove(10);
		 System.out.println(param_2);
		 obj.insert(20);
		 int param_3 = obj.getRandom();
		 System.out.println(param_3);
		 
	}
	
	
	 HashMap<Integer, Integer> map;
	    ArrayList<Integer> list;
	    
	    /** Initialize your data structure here. */
	    public RandomizedSet() {
	        map = new HashMap<Integer, Integer>();
	        list = new ArrayList<Integer>();
	    }
	    
	    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
	    public boolean insert(int val) {
	        if(map.containsKey(val)) {
	            return false;
	        }else {
	            map.put(val, list.size());
	            list.add(val);
	            return true;
	        }
	    }
	    
	    /** Removes a value from the set. Returns true if the set contained the specified element. */
	    public boolean remove(int val) {
	        if(!map.containsKey(val)) {
	            return false;
	        }else {
	            int key = map.get(val);
	            int lastElement = list.get(list.size() - 1);
	            map.put(lastElement, key);
	            list.set(key, lastElement);
	            map.remove(val);
	            list.remove(list.size() - 1);
	            return true;
	        }
	    }
	    
	    /** Get a random element from the set. */
	    public int getRandom() {
	        Random random = new Random();
	        return list.get( random.nextInt(list.size()) );
	    }
}
