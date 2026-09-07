class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int[] last = new int[26];
        int dp = 1;
        for (char c : s.toCharArray()) {
            int old = dp;
            dp = (dp * 2) % mod;
            dp = (dp - last[c - 'a'] + mod) % mod;
            last[c - 'a'] = old;
        }
        return (dp - 1 + mod) % mod;
    }
}