class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; 
            return a[0] - b[0]; 
        });
        int n = envelopes.length;
        int[] arra = new int[n];
        int size = 0;
        for (int[] env : envelopes) {
            int h = env[1];
            int inx = lowerBound(arra, 0, size, h);
            arra[inx] = h;
            if (inx == size) size++;
        }
        return size;
    }
    private int lowerBound(int[] arr, int left, int right, int target) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
