

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CopyListWithRandomPointer {

	public static void main(String[] args) {
		CopyListWithRandomPointer copy = new CopyListWithRandomPointer();
		int[] arr = {1,2,3};
		RandomLinkedList head = createList(arr);
		print(head);
		copy.copy(head);
		System.out.println("==========");
		print(head);
	}
	
	public RandomLinkedList copy (RandomLinkedList head) {
        if (head == null) {
            return null;
        }
        Map<RandomLinkedList, RandomLinkedList> map = new HashMap<RandomLinkedList, RandomLinkedList>();
        RandomLinkedList p = head;
        RandomLinkedList cloneNode = new RandomLinkedList(head.value);
        map.put(head, cloneNode);
        
        for( RandomLinkedList key : map.keySet() ){ 
        	System.out.println( "first key : " + key.value + ", value : " + map.get(key).value ); 
        }
        
       	System.out.println("head: "+head.value);
        while (p != null) {
            if (p.next != null) {
            	System.out.println("p.next: "+p.next);
            	System.out.println("p.next: "+p.next.value);
            
            	for( RandomLinkedList key : map.keySet() ){ System.out.println( "key : " + key.value + ", value : " + map.get(key).value ); }
                if (map.containsKey(p.next)) {
                    cloneNode.next = map.get(p.next);
                } else {
                    RandomLinkedList newNode = new RandomLinkedList(p.next.value);
                    map.put(p.next, newNode);
                    cloneNode.next = newNode;
                }
            }
            if (p.random != null) {
                if (map.containsKey(p.random)) {
                    cloneNode.random = map.get(p.random);
                } else {
                    RandomLinkedList newNode = new RandomLinkedList(p.random.value);
                    map.put(p.random, newNode);
                    cloneNode.next = newNode;}
            }
            p = p.next;
            cloneNode = cloneNode.next;
        }
        return map.get(head);
    }
	
	
	public static RandomLinkedList createList(int[] arr) {
		if(arr.length ==0)
			return null;
		
		RandomLinkedList head = new RandomLinkedList(arr[0]);
		RandomLinkedList last = head;
		
		List<RandomLinkedList> list = new ArrayList<RandomLinkedList>(arr.length);
		list.add(last);
		for(int i=1; i<arr.length; i++) {
			RandomLinkedList node = new RandomLinkedList(arr[i]);
			last.next = node;
			last= node;
			list.add(node);
		}
		
		Random random = new Random();
		for(int i=0; i<arr.length; i++) {
			System.out.println(Math.abs(random.nextInt()));
			System.out.println(arr.length+1);
		
			int rand = Math.abs(random.nextInt())%(arr.length+1);
			System.out.println(rand);
			if(rand != arr.length) {
				list.get(i).random= list.get(rand);
			}
		}
		return head;
	}
	
	public static void print(RandomLinkedList head) {
		List<Integer> values = new ArrayList<>();
		List<String> list = new ArrayList<>();
		
		while(head != null) {
			values.add(head.value);
				if(head.random != null) {
					list.add(head.value+"---->"+head.random.value);
				}
			    head = head.next;
		}
		list.add(0, Arrays.toString(values.toArray(new Integer[values.size()])));
		 System.out.println(Arrays.toString(list.toArray(new String[list.size()])));
	}
	
	static class RandomLinkedList{
		int value;
		RandomLinkedList random;
		RandomLinkedList next;
		
		public RandomLinkedList(int x) {
			this.value = x;
		}
	}
}
