class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long left = 1;
        long right = (long) coins[0] * k;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (count(mid, coins, 0, 1, 0) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }

    public long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
    }

    public long count(long x, int[] coins, int index, long currLCM, int selected){
        long ans = 0;
        for (int i = index; i < coins.length; i++) {
            long newLCM = lcm(currLCM, coins[i]);
            long value = x / newLCM;
            if ((selected + 1) % 2 == 1) {
                ans += value;
            } else {
                ans -= value;
            }
            ans += count(x,coins,i + 1,newLCM,selected + 1);
        }
        return ans;
    }
}