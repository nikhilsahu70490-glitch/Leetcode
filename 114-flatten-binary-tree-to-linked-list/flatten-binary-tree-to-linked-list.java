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
class Solution {
    public void flatten(TreeNode root) {
        TreeNode curr = root;
        
        while (curr != null) {
            // If there is a left child, we must rewire it
            if (curr.left != null) {
                // Find the rightmost node in the left subtree
                TreeNode predecessor = curr.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                
                // Link the rightmost node of the left subtree to curr's right subtree
                predecessor.right = curr.right;
                
                // Move the left subtree to the right side
                curr.right = curr.left;
                curr.left = null; // Set left pointer to null
            }
            
            // Move down to the next right node
            curr = curr.right;
        }
    }
}