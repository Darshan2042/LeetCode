class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        int pro = 1;
        int zeroCount = 0;
        for(int num : nums){
            if(num == 0){
                zeroCount++;
            }else{
                pro *= num;
            }
        }
        for (int i = 0; i < n; i++) {
            if (zeroCount >= 2) {
                res[i] = 0;
            } else if (zeroCount == 1) {
                if (nums[i] == 0) {
                    res[i] = pro;
                } else {
                    res[i] = 0;
                }
            } else {
                res[i] = pro / nums[i];
            }
        }
        return res;
    }
}