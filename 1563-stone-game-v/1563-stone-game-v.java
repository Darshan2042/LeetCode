class Solution {
    public int stoneGameV(int[] stoneValue) {
        int start = 0;
        int end = stoneValue.length-1;

        int n = stoneValue.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        int[] prefix = new int[n + 1];

        for(int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }
        return solve(stoneValue, start, end,dp,prefix);
    }

    public int solve(int[] nums, int start, int end,int[][] dp,int[] prefix){
        if(dp[start][end] != -1){
            return dp[start][end];
        }
        int maxscore = 0;
        for(int i=start; i<end; i++){
            int leftsum = prefix[i + 1] - prefix[start];
            int rightsum = prefix[end + 1] - prefix[i + 1];
            int score = 0;
            if(leftsum < rightsum){
                score = leftsum + solve(nums,start,i,dp,prefix);
            }
            else if(rightsum < leftsum){
                score = rightsum + solve(nums,i+1,end,dp,prefix);
            }
            else{
                int leftscore = leftsum + solve(nums,start,i,dp,prefix);
                int rightscore = rightsum + solve(nums,i+1,end,dp,prefix);
                score = Math.max(leftscore,rightscore);
            }

            maxscore = Math.max(maxscore, score);
        }
        dp[start][end] = maxscore;
        return dp[start][end];
    }

    public int add(int[] nums, int start, int end){
        int sum = 0;
        for(int i=start; i<end; i++){
            sum += nums[i];
        }
        return sum;
    }
}