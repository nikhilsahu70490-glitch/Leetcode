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
        
        Node curr = root; // tracks the current node on the level we are traversing
        
        while (curr != null) {
            Node dummy = new Node(0); // dummy node to anchor the head of the next level
            Node prev = dummy;       // tracking pointer to build the next level's linked list
            
            // Traverse horizontally across the current level
            while (curr != null) {
                if (curr.left != null) {
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if (curr.right != null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next; // move to the next neighbor on the current level
            }
            
            // Move down to the start of the next level we just constructed
            curr = dummy.next;
        }
        
        return root;
    }
}