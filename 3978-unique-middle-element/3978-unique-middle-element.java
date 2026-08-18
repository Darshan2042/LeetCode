class Solution {
    public boolean isMiddleElementUnique(int[] nums) {
        int mid = nums.length/2;
        boolean isvalid = false;
        for(int i=0; i<nums.length; i++){
            if(nums[mid] == nums[i] && mid != i){
                isvalid = true;
            }
        }
        return !isvalid;
    }
}