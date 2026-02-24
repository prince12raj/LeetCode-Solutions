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
    public int dfs(TreeNode node, int currentNumber) {
        if (node == null) {
            return 0;
        }
        currentNumber = currentNumber * 2 + node.val;
        if (node.left == null && node.right == null) {
            return currentNumber;
        }
        int leftSum = dfs(node.left, currentNumber);
        int rightSum = dfs(node.right, currentNumber);
        return leftSum + rightSum;
    }
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
}