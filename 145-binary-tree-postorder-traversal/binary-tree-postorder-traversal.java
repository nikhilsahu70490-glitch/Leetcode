import java.util.*;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            // Add to the front of the list (effectively reversing the order)
            result.addFirst(curr.val);
            
            // Push left first so right is processed first (Root -> Right -> Left)
            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
        }
        
        return result;
    }
}