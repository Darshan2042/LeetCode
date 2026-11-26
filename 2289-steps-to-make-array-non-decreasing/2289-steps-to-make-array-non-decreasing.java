class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int maxstep = 0;
        for(int i=0; i<nums.length; i++){
            int step = 0;
            while(!stack.isEmpty() && stack.peek()[0] <= nums[i]){
                step = Math.max(stack.peek()[1],step);
                stack.pop();
            }
            if(stack.isEmpty()){
                step = 0;
            }else{
                step = step+1;
            }

            maxstep = Math.max(step,maxstep);
            stack.push(new int[]{nums[i], step});
        }
        return maxstep;
    }
}