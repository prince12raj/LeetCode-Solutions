class Solution {
    public String longestCommonPrefix(String[] v) {
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length - 1];
        int i = 0;
        while (i < first.length() && i < last.length()
                && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }
}