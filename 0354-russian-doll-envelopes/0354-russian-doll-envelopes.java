class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; 
            return a[0] - b[0];
        });
        ArrayList<Integer> lis = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) {
            int h = envelopes[i][1];
            if (lis.isEmpty() || h > lis.get(lis.size() - 1)) {
                lis.add(h);
            } else {
                int idx = lowerBound(lis, h);
                lis.set(idx, h);
            }
        }
        return lis.size();
    }
    private int lowerBound(ArrayList<Integer> arr, int target) {
        int left = 0, right = arr.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr.get(mid) < target)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
}
