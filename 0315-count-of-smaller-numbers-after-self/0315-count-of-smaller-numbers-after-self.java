class Solution {
    class SegmentTree {
        int[] tree;
        int size;
        SegmentTree(int n) {
            size = n;
            tree = new int[4 * n];
        }
        void update(int node, int start, int end, int idx) {
            if (start == end) {
                tree[node] += 1;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid)
                update(2 * node, start, mid, idx);
            else
                update(2 * node + 1, mid + 1, end, idx);
            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }
        int query(int node, int start, int end, int left, int right) {
            if (right < start || end < left) return 0;
            if (left <= start && end <= right) return tree[node];
            int mid = (start + end) / 2;
            return query(2 * node, start, mid, left, right) +
                   query(2 * node + 1, mid + 1, end, left, right);
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        Map<Integer, Integer> rank = new HashMap<>();
        int r = 0;
        for (int num : sorted) {
            if (!rank.containsKey(num)) {
                rank.put(num, r++);
            }
        }
        SegmentTree seg = new SegmentTree(r);
        Integer[] res = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            int idx = rank.get(nums[i]);
            if (idx > 0)
                res[i] = seg.query(1, 0, r - 1, 0, idx - 1);
            else
                res[i] = 0;
            seg.update(1, 0, r - 1, idx);
        }
        return Arrays.asList(res);
    }
}