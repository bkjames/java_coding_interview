
	public static void main(String[] args) {
		G308_TimeBasedKeyValueStore task = new G308_TimeBasedKeyValueStore();
		task.set("foo", "bar", 1);
		System.out.println(task.get("foo", 1));
		System.out.println(task.get("foo", 3));
		System.out.println(task.get("foo", 0));
		task.set("foo", "bar2", 4);
		System.out.println(task.get("foo", 3));
		System.out.println(task.get("foo", 4));
		System.out.println(task.get("foo", 5));
	}
  
Binary search:

class TimeMap {

    class Node {
        String value;
        int timestamp;
        Node(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    
    Map<String, List<Node>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList());
        map.get(key).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Node> nodes = map.get(key);
        if (nodes == null) return "";
        
        int left = 0, right = nodes.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            Node node = nodes.get(mid);
            if (node.timestamp == timestamp) {
                return node.value;
            } else if (node.timestamp < timestamp) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (nodes.get(right).timestamp <= timestamp) return nodes.get(right).value;
        else if (nodes.get(left).timestamp <= timestamp) return nodes.get(left).value;
        return "";
    }
}
TreeMap:

class TimeMap {

    Map<String, TreeMap<Integer, String>> map;
    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new TreeMap());
        map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        
        if (treeMap == null) return "";
        
        Integer floorKey = treeMap.floorKey(timestamp);
        
        if (floorKey == null) return "";
        return treeMap.get(floorKey);
    }
}
