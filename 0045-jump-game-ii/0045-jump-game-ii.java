class Solution {
   public int jump(int[] A) {
    int jump =0;
    int curdi  =0;
    int fur = 0;
    for(int i = 0; i < A.length -1; i ++){
        fur = Math.max(fur, i + A[i]);
        if(i == curdi){
            jump++;
            curdi = fur;
        }
    }
    return jump;
   }
}