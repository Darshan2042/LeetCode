class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> list = new HashSet<>();
        for(int num : nums){
            list.add(num);
        }
        int pre = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] == nums[i-1]+1){
                pre += nums[i];
            }
            else{
                break;
            }
        }
        while(list.contains(pre)){
            pre++;
        }
        return pre;
    }
}