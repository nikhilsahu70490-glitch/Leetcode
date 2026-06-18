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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Base case: if the tree/node is empty, no path exists
        if (root == null) {
            return false;
        }
        
        // Base case: if it's a leaf node, check if the remaining sum equals the node's value
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        // Recursive case: subtract the current node's value and check both subtrees
        int remainingSum = targetSum - root.val;
        return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
    }
}