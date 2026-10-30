class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(sum >= target){
                int l = right - left +1;
                min = Math.min(min,l);
                sum -= nums[left];
                left++; 
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }else{
            return min;
        }
    }
}