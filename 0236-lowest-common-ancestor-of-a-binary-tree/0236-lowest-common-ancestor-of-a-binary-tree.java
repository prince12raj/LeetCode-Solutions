/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null || root == p || root == q){
        return root;
      }  
      //left me move karengenge or check karenge root ka left p or q ke equal h ya nahi recursive chalega
      TreeNode left = lowestCommonAncestor(root.left, p ,q);
      //right me move karengenge or check karenge root ka right p or q ke equal h ya nahi recursive chalega
      TreeNode right = lowestCommonAncestor(root.right, p ,q);
      //dono ke left null ho to ansestor root hoga
      if(left != null && right !=null){
        return root;
      }
      // agar left null hua to right return and right null hua  to  return left hoga
      return left !=null ? left : right;
    }
}