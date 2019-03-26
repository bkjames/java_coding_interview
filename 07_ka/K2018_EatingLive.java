package real;
import java.util.*;
public class K2018_EatingLive {
	
	

	    class Food{
	        int time;
	        int idx;
	        Food(int t, int idx){
	            this.time = t;
	            this.idx = idx;
	        }
	    }
	    
	    public static void main(String[] args) {
	    	int[] nums = {3, 1, 2};
	    	long k = 5;
	    	K2018_EatingLive a = new K2018_EatingLive();
	    	System.out.println(a.solution(nums, k));
		}
	    
	

        Comparator<Food> CompTime = new Comparator<Food>(){
            public int compare(Food a, Food b){
                return a.time-b.time;
            }
        };

        Comparator<Food> CompIdx = new Comparator<Food>(){
            public int compare(Food a, Food b){
                return a.idx-b.idx;
            }
        };

        public int solution(int[] food_times, long k) {
            int answer = 0;
            List<Food> foods = new LinkedList<Food>();
            int n =food_times.length;
            for(int i =0; i< n; ++i)
                foods.add(new Food(food_times[i], i+1));
            foods.sort(CompTime);

            int preTime =0;
            int i =0;
            for(Food f: foods){
                long diff = f.time-preTime;
                System.out.println("diff: "+diff);
                if(diff !=0 ){
                    long spend = diff* n;
                    System.out.println("spend: "+spend);
                    if(spend <=k){
                        k-= spend;
                        preTime = f.time;
                    }else{
                        k%= n;
                        foods.subList(i, food_times.length).sort(CompIdx);
                        return foods.get(i+(int)k).idx;
                    }
                }

            ++i;
            --n;
            }
            return -1;
        }
}
