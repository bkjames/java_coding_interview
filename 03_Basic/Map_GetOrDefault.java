import java.util.*;

//getOrDefault
//default V getOrDefault(Object key, V defaultValue)
//찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.

public class MapGetOrDefault {
	public static void main(String[] args) {
		String[] arr1 = {"a", "b", "a", "d"};
//		String[] arr2 = {"a", "b", "w"};

		Map<String, Integer> map = new HashMap<String, Integer>();
		for(String a : arr1) 
			map.put(a, map.getOrDefault(a, 0) + 1);
		System.out.println(map);
	}
	
}
