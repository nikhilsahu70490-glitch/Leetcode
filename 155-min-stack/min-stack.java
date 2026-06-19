class MinStack {
    private class Node {
        int val;
        int min;
        Node next;
        
        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    private Node head;

    public MinStack() {
        head = null;
    }
    
    public void push(int val) {
        if (head == null) {
            // If the stack is empty, the current value is also the minimum
            head = new Node(val, val, null);
        } else {
            // The new minimum is the lesser of the current value and the previous minimum
            int currentMin = Math.min(val, head.min);
            head = new Node(val, currentMin, head);
        }
    }
    
    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}