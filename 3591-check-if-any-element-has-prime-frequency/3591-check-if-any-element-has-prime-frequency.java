class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        int[] arr = new int[101];
        for(int i=0; i<nums.length; i++){
            int num = nums[i];
            arr[num]++;
        }
        for(int i=0; i<arr.length; i++){
            if(isPrime(arr[i])){
                return true;
            }
        }
        return false;
    }
    public boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for(int i=2; i*i<=n; i++){
            if(n % i== 0){
                return false;
            }
        }
        return true;
    }
}