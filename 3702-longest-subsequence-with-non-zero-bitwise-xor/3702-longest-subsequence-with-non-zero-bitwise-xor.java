class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean check = false;
        int n = nums.length;
        for(int num :nums){
            xor ^= num;

            if(xor != 0){
                check = true;
            }
        }

        if(xor != 0){
            return n;
        }

        if(check){
            return n-1;
        }
        return 0;
    }
}