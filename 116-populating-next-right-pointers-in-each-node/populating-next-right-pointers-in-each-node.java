/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        // Start with the first level (the root)
        Node leftmost = root;
        
        // Loop runs until we reach the leaf level
        while (leftmost.left != null) {
            Node curr = leftmost;
            
            // Traverse horizontally across the current level
            while (curr != null) {
                // Connection 1: link left child to right child
                curr.left.next = curr.right;
                
                // Connection 2: link right child to neighbor's left child
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                
                // Move across the current level
                curr = curr.next;
            }
            
            // Move down to the next level
            leftmost = leftmost.left;
        }
        
        return root;
    }
}