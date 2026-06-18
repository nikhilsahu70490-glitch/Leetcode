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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE; // Initialize to the smallest possible value
        gainFromNode(root);
        return maxSum;
    }

    private int gainFromNode(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively get the max path sum from left and right subtrees.
        // If the path sum is negative, we ignore it by taking Math.max(0, ...)
        int leftGain = Math.max(gainFromNode(node.left), 0);
        int rightGain = Math.max(gainFromNode(node.right), 0);

        // Price of a new path with the current node as the highest apex node
        int currentPathSum = node.val + leftGain + rightGain;

        // Update our global maximum if the current local path is larger
        maxSum = Math.max(maxSum, currentPathSum);

        // For the parent call, a path can only extend through one of the two children
        return node.val + Math.max(leftGain, rightGain);
    }
}