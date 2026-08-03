class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n+1];
        for(int i=n-1; i>=0 ; i--){
            int sum = 0;
            int best = Integer.MIN_VALUE; // Start with the smallest value because we want the maximum answer.
            for(int k=0; k<3 && i+k<n; k++){// Try taking 1, 2, or 3 stones i + k < n prevents going outside the array.
                sum += stoneValue[i+k];
                best = Math.max(best,sum-dp[i+k+1]);// Choose the move that gives the maximum score difference.
            }
            dp[i] = best;
        }

        if(dp[0] > 0){
            return "Alice";
        }
        else if(dp[0] < 0){
            return "Bob";
        }
        else{
            return "Tie";
        }
    }
}