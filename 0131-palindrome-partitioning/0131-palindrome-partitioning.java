class Solution {
    int n;
    public List<List<String>> partition(String s) {
        n = s.length();
        List<List<String>> ans = new ArrayList<>();
        List<String> temp =  new ArrayList<>();
        fxn(ans, temp, s, 0);
        return ans;
    }
    private void fxn(List<List<String>> ans, List<String> temp, String s, int idx){
        if(idx == n ){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = idx; i < s.length(); i++){
            if(fxn2(s,idx,i)){
                temp.add(s.substring(idx, i+1));
                fxn(ans, temp, s, i+1);
                temp.remove(temp.size()- 1);
            }
        }
    }
    private boolean fxn2(String s, int l, int r){
        while(l < r){
            if(s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}