class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res = new int[seq.length()];
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<seq.length(); i++){
            char ch = seq.charAt(i);
            if(ch == '('){
                stack.push(ch);
                int depth = stack.size();
                res[i] = depth % 2;
            }
            else{
                int depth = stack.size();            
                res[i] = depth % 2;
                stack.pop();
            }
        }
        return res;
    }
} 