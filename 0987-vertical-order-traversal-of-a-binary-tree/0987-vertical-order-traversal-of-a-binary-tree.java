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
    Map<Integer, List<int[]>> mp = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, List<int[]>> i : mp.entrySet()) {
            List<int[]> list = i.getValue();
            Collections.sort(list, (a, b) -> {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            });
            List<Integer> v = new ArrayList<>();
            for (int[] j : list) {
                v.add(j[1]);
            }
            ans.add(v);
        }
        return ans;
    }
    private void dfs(TreeNode node, int row, int col) {
        if (node == null) return;
        mp.putIfAbsent(col, new ArrayList<>());
        mp.get(col).add(new int[]{row, node.val});
        dfs(node.left, row + 1, col - 1);
        dfs(node.right, row + 1, col + 1);
    }
}