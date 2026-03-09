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
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         List<Integer> t1 = new ArrayList<>();
//         List<Integer> t2 = new ArrayList<>();
//         inorder(p, t1);
//         inorder(q, t2);
//         return t1.equals(t2);
//     }
//     void inorder(TreeNode root, List<Integer> list) {
//         if(root == null){
//             list.add(null);
//             return;
//         }
//         inorder(root.left, list);
//         list.add(root.val);
//         inorder(root.right, list);
//     }
// }
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}