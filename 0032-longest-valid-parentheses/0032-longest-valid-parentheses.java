class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() <= 1){
            return 0;
        }
        if(s.length() == 2 && s.charAt(0) == '(' && s.charAt(1) == ')'){
            return 2;
        }
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }
            else{
                stack.pop();

                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    int len = i - stack.peek();
                    max = Math.max(len,max);
                }
            }
        }
        return max;
    }
}