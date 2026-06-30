class Solution {
    public int lengthOfLIS(int[] nums) {
    ArrayList<Integer> res = new ArrayList<>();
    for(int i = 0 ; i < nums.length; i++){
        int idx = fxn(res, nums[i]);
        if(idx == res.size()){
        res.add(nums[i]);
    }
    else{
        res.set(idx , nums[i]);
    }
    }
    return res.size();
    }
    int fxn(ArrayList<Integer> res , int target){
        int l = 0;
        int h = res.size()-1;
        while(l <= h){
            int mid = (l+h)/2;
            if(res.get(mid) < target){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return l;
    }
}