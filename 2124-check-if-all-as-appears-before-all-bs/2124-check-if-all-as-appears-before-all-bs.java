class Solution {
    public boolean checkString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == 'a'){
                if(!stack.isEmpty() && stack.pop() == 'b'){
                    return false;
                }
            }
            stack.push(ch);
        }
        return true;
    }
}