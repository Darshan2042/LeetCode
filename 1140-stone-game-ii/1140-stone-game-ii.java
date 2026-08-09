class Solution {
    public int stoneGameII(int[] p) {
        int n = p.length;
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++)
            pre[i + 1] = pre[i] + p[i];
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                for (int x = 1; x <= Math.min(2 * m, n - i); x++) {
                    int take = pre[i + x] - pre[i];
                    int remain = pre[n] - pre[i + x];
                    dp[i][m] = Math.max(dp[i][m],
                        take + remain - dp[i + x][Math.max(m, x)]);
                }
            }
        }
        return dp[0][1];
    }
}