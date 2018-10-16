package zcode01;

import java.util.HashMap;

public class LRU {

    public static class Node<K, V> {
        public K key;
        public V value;
        public Node<K, V> pre;
        public Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }

    public static class DoubleLinkedList<K, V> {
        private Node<K, V> head;
        private Node<K, V> tail;

        public DoubleLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node<K, V> newNode) {
            if (newNode == null) {
                return;
            }
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                tail = newNode;
            }
        }

        public void moveNodeToTail(Node<K, V> node) {
            if (tail == node) {
                return;
            }

            if (head == node) {
                head = node.next;
                head.pre = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }

        public Node<K, V> removeHead() {
            if (head == null) {
                return null;
            }

            Node<K, V> removedNode = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = removedNode.next;
                head.pre = null;
                removedNode.next = null;
            }
            return removedNode;
        }

    }

    public static class LRUCache<K, V> {
        private HashMap<K, Node<K, V>> map;
        private DoubleLinkedList<K, V> list;
        private final int CAPACITY;

        public LRUCache(int capacity) {
            // do intialization
            if (capacity < 1) {
                throw new RuntimeException("should be more than 0.");
            }
            map = new HashMap<>();
            list = new DoubleLinkedList<>();
            this.CAPACITY = capacity;
        }

        public V get(K key) {
            if (map.containsKey(key)) {
                Node<K, V> node = map.get(key);
                list.moveNodeToTail(node);
                return node.value;
            }
            return null;
        }

        public void set(K key, V value) {
            if (map.containsKey(key)) {
                Node<K, V> node = map.get(key);
                node.value = value;
                list.moveNodeToTail(node);
            } else {
                Node<K, V> newNode = new Node<>(key, value);
                map.put(key, newNode);
                list.addNode(newNode);
                if (map.size() > CAPACITY) {
                    removeMostUnusedCache();
                }
            }
        }

        private void removeMostUnusedCache() {
            Node<K, V> removedNode = list.removeHead();
            map.remove(removedNode.key);
        }

    }

    public static void main(String[] args) {
        LRUCache<String, Integer> testCache = new LRUCache<>(3);
        testCache.set("A", 1);
        testCache.set("B", 2);
        testCache.set("C", 3);
        System.out.println(testCache.get("B"));
        System.out.println(testCache.get("A"));
        testCache.set("D", 4);
        System.out.println(testCache.get("D"));
        System.out.println(testCache.get("C"));
    }

}
