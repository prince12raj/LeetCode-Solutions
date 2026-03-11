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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathsum(root);
        return maxSum;
    }
    int maxPathsum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(0, maxPathsum(root.left));
        int r = Math.max(0, maxPathsum(root.right));
        maxSum = Math.max(maxSum, root.val + l + r);
        return root.val + Math.max(l, r);
    }
}