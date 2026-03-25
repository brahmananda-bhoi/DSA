class LRUCache {
    // Doubly Linked List Node
    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private int capacity;
    private Map<Integer, Node> map;
    private Node head;  // Dummy head (most recently used end)
    private Node tail;  // Dummy tail (least recently used end)
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        // Initialize dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        // Move to most recently used position
        removeNode(node);
        addToHead(node);
        return node.value;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // Update existing node
            Node node = map.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            // Create new node
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
            // Check capacity and evict LRU if needed
            if (map.size() > capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }
        }
    }
    // Helper: Remove node from its current position
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // Helper: Add node right after head (most recently used)
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}