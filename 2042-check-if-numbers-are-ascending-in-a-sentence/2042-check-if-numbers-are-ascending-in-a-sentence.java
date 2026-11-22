class Solution {
    public boolean areNumbersAscending(String s) {
        Stack<Integer> stack = new Stack<>();
        String[] arr = s.split(" ");
        for(String word : arr){
            if(Character.isDigit(word.charAt(0))){
                int num  = Integer.parseInt(word);
            
                if(!stack.isEmpty()){
                    if(num <= stack.peek()){
                        return false;
                    }
                }
                stack.push(num);
            }
        }
        return true;
    }
}