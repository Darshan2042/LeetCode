class Solution {
    public String removeOuterParentheses(String s) {
        char[] arr = s.toCharArray();
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        int open = 0;
        int close = 0;
        for(char ch : arr){
            if(ch == '('){
                sb.append(ch);
                open++;
            }
            if(ch == ')'){
                sb.append(ch);
                close++;
            }
            if(open == close){
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length()-1);
                res.append(sb);
                sb.setLength(0);
                open = 0;
                close = 0;
            }
        }
        return res.toString();
    }
}