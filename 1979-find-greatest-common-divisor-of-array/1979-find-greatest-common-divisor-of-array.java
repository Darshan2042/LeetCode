class Solution {
    public int findGCD(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for(int i=0 ; i<nums.length ; i++){
            if(min > nums[i]){
                min = nums[i];
            }

            if(max < nums[i]){
                max = nums[i];
            }
        }
        return gcd(min,max);
    }

    public int gcd(int a , int b){
        if(b == 0){
            return a;
        }
        return gcd(b , a%b);
    }
}