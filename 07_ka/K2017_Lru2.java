package real;

import java.util.*;
public class K2017_Lru2 {
	



	    // 가상의 캐시
	    LinkedHashMap<String,Long> map = null;

	    final static int CACHE_MISS = 5;
	    final static int CACHE_HIT = 1;

	    public int solution(int cacheSize, String[] cities) {
	        int answer = 0;
	        map = new LinkedHashMap<>();
	        for (String citie:cities) {
	            answer += solutionLRU(cacheSize, citie);
	        }
	        System.out.println("answer: "+answer);
	        return answer;
	    }

	    // LFU는 가장 적은 참조시간을 갖는 페이지를 교체
	    public int solutionLRU(int cacheSize, String citie) {
	        if (cacheSize==0) return CACHE_MISS;
	        citie = citie.toLowerCase();
	        if(map.get(citie) != null) {
	            map.put(citie,new Date().getTime());
	            return CACHE_HIT;
	        } else {
	            if (map.size() >= cacheSize) {
	                String deleteKey = null;
	                for ( String key : map.keySet() ) {
	                    if (deleteKey == null) {
	                        deleteKey = key;
	                    } else {
	                        if(map.get(deleteKey) > map.get(key)){
	                            deleteKey = key;
	                        }
	                    }
	                }
	                map.remove(deleteKey);
	            }
	            map.put(citie,new Date().getTime());
	            return CACHE_MISS;
	        }
	    }


	    // LFU는 가장 적은 참조횟수를 갖는 페이지를 교체
	    public int solutionLFU(int cacheSize, String citie) {
	        if (cacheSize==0) return CACHE_MISS;
	        citie = citie.toLowerCase();
	        if(map.get(citie) != null) {
	            map.put(citie,map.get(citie)+1l);
	            return CACHE_HIT;
	        } else {
	            if (map.size() >= cacheSize) {
	                String deleteKey = null;
	                for ( String key : map.keySet() ) {
	                    if (deleteKey == null) {
	                        deleteKey = key;
	                    } else {
	                        if(map.get(deleteKey) > map.get(key)){
	                            deleteKey = key;
	                        }
	                    }
	                }
	                map.remove(deleteKey);
	            }
	            map.put(citie,1l);
	            return CACHE_MISS;
	        }
	    }

	    public static void main(String[] args) {

	    	K2017_Lru sl = new K2017_Lru();
	        String[] cities = {"Jeju", "Pangyo", "NewYork","Jeju", "Aewyork","ANewYork", "Jeju","NewYork", "Jeju","Aewyork", "Jeju","Pangyo"};
	    	
	        
	        System.out.println(
	        sl.solution(4, cities));
	        
	        
	        sl.solution(3, new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
	        sl.solution(3,	new String[] {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"});
	        sl.solution(2,	new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
	        sl.solution(5,	new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"});
	        sl.solution(2,	new String[] {"Jeju", "Pangyo", "NewYork", "newyork"});
	        sl.solution(0,	new String[] {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"});


	    }

	
}
