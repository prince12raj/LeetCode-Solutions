class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        int n =  envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1]; 
            return a[0] - b[0];
        });
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            int h = envelopes[i][1];
            if(arr.isEmpty() || h > arr.get(arr.size() -1)){
            arr.add(h);
            }
            else{
                int ind = lower(arr , h);
                arr.set(ind, h);

            }
        }
        return arr.size();
    }
    private int lower(ArrayList<Integer> arr, int target){
        int l = 0;
        int r = arr.size();
        while(l < r){
            int mid = (l+r) /2;
            if(mid > target){
                l = mid+1;
            }
            else {
                return r =mid;
            }
        }
        return l;
    }
}
