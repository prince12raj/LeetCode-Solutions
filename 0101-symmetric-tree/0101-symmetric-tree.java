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
    public boolean isSymmetric(TreeNode root) {
        return root == null || fxn(root.left, root.right);
    }
    
    private boolean fxn(TreeNode a, TreeNode b) {
        return a == b || (a != null && b != null && a.val == b.val && 
        fxn(a.left, b.right) && fxn(a.right, b.left));
    }
}
