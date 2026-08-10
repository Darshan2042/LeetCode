class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n+1];
        dp[0] = false;
        for(int i=1; i<=n; i++){
            int sq = 1;
            while(sq * sq <= i){
                int rem = i - sq * sq;
                if(dp[rem] == false){
                    dp[i] = true;
                    break;
                }
                sq++;
            }
        } 
        return dp[n];
    }
}