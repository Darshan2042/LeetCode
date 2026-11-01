class Solution {
    public int minMoves(int[] nums) {
        int count =0;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            min = Math.min(min,num);
        }
        for(int i=0; i<nums.length; i++){
            count += nums[i] - min;
        }
        return count;
        
    }
}