class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch != ')'){
                st.push(ch);
            }
            else{
                StringBuilder sb  = new StringBuilder();
                while(st.peek() != '('){
                    sb.append(st.pop());
                }
                st.pop();

                for (char c : sb.toString().toCharArray()) {
                    st.push(c);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}