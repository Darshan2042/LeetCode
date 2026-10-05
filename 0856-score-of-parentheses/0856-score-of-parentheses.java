class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '('){
                stack.push(0);
            }
            else if(ch  == ')'){
                int curr = stack.pop();
                if(curr == 0){
                    curr = 1;
                }
                else{
                    curr *= 2;
                }

                if(!stack.isEmpty()){
                    int p = stack.pop();
                    stack.push(p+curr);
                }
                else{
                    stack.push(curr);
                }
            }
        }
        int top = stack.pop();
        return top;
    }
}