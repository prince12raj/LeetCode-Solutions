class Solution {
    public boolean lemonadeChange(int[] bills) {
        int cs =0;
        int ct=0;
        int ctw =0;
        for(int a : bills){
            if(a == 5){
                cs++;
            }
            if(a ==10){
                if(cs > 0){
                    cs--;
                    ct++;
                }else{
                    return false;
                }
            }
            if(a == 20){
                if(cs > 0 && ct >0){
                    cs--;
                    ct--;
                    ctw++;
                }else if(cs >2){
                    cs -=3;
                }
                else{
                    return false;
                }
            }
            
        }
        return true;
    }
}