import java.util.HashMap;
import java.util.Map;

class LRUCache {
    
    // Node structure for our doubly linked list
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        
        // Initialize dummy head and tail nodes to avoid edge cases
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        
        Node node = map.get(key);
        // Move the accessed node to the head (most recently used)
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value; // Update the value
            moveToHead(node);   // Mark as most recently used
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addNode(newNode); // Add to the head
            
            if (map.size() > capacity) {
                // Evict the least recently used node from tail
                Node lruNode = tail.prev;
                removeNode(lruNode);
                map.remove(lruNode.key);
            }
        }
    }
    
    // Helper: Always add the new node right after the dummy head
    private void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        
        head.next.prev = node;
        head.next = node;
    }
    
    // Helper: Remove an existing node from the linked list
    private void removeNode(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    // Helper: Move a node to the front of the list
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }
}