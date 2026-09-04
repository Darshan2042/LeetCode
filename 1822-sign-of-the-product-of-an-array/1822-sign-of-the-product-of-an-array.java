class Solution {
    public int arraySign(int[] nums) {
        long sum = 1;
        for(int num : nums){
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                sum *= -1;
            }
        }
        return signfunc(sum);
    }

    public int signfunc(long n){
        if(n < 0){
            return -1;
        }
        else if(n > 0){
            return 1;
        }
        else{
            return 0;
        }
    }
}