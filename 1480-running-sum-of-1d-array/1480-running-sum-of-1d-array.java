class Solution {
    public int[] runningSum(int[] nums) {
        int[] arr = new int[nums.length];
        int pre = 0;
        for(int i=0 ; i<nums.length ; i++){
            pre += nums[i];
            arr[i] = pre;
        }
        return arr;
    }
}