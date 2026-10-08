class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length();i++){
            char c = s.charAt(i);
            if(c == ')'){
                st.pop();
            }
            if(!st.isEmpty()){
                sb.append(c);
            }
            if(c == '('){
                st.push(c);
            }
        }
        return sb.toString();
    }
}