class Solution {
    public String reverseWords(String s) {
        String re = "";
        int l = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1 || s.charAt(i) == ' ') {
                int r;
                if (i == s.length() - 1) {
                    r = i;
                } else {
                    r = i-1 ;
                }
                while (r > l) {
                    re = re + s.charAt(r);
                    r--;
                }
                if (i != s.length() - 1) {
                    re = re + " ";
                }
                l = i;
            }
        }
        return re;
    }
}