class Solution {
    public int pivotInteger(int n) {
        int totalSum = 0;
        int currSum = 0;
        for(int i=1; i<=n; i++){
            totalSum += i;
        }
        for(int i=1; i<=n; i++){
            currSum += i;
            int ans  = totalSum - currSum + i;
            if(currSum == ans){
                return i;
            }
        }
        return -1;
    }
}