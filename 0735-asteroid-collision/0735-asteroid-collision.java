class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack  = new Stack<>();
        for(int num : asteroids){
            if(num > 0){
                stack.push(num);
            }
            else{
                boolean isalive = true;
                while(!stack.isEmpty() && stack.peek() > 0){
                    if(Math.abs(num) > stack.peek()){
                        stack.pop();
                        continue;
                    }
                    else if(Math.abs(num) == stack.peek()){
                        stack.pop();
                        isalive = false;
                        break;
                    }
                    else if(stack.peek() > Math.abs(num)){
                        isalive = false;
                        break;
                    }
                }
                if(isalive){
                    stack.push(num);
                }
            }
        }
        int[] res = new int[stack.size()];
        for(int i=res.length-1; i>=0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}