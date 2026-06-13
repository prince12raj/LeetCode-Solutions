class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder re = new StringBuilder();
        for(String word : words){
            int tw =0;
            for(char c : word.toCharArray()){
                tw+=weights[c - 'a'];
                
            }
            int mod = tw % 26;
            char mc =(char) ('z' - mod);
            re.append(mc);
        }
        return re.toString();
    }
}