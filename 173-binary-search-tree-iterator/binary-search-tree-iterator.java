import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    // Stack to store the ancestors of the current node
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        // Initialize the stack by pushing all left children down to the smallest element
        pushAllLeft(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        // The top of the stack is the next smallest element
        TreeNode node = stack.pop();
        
        // If the popped node has a right child, we must process its left branch
        if (node.right != null) {
            pushAllLeft(node.right);
        }
        
        return node.val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Helper method to push a node and all of its left descendants onto the stack
    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */