
import java.util.*;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007L;
        int n = nums.size();
        long ans = 0;

        int[] arr = new int[n];
        int[] bitCount = new int[31];

        for (int i = 0; i < n; i++) {
            arr[i] = nums.get(i);

            for (int bit = 0; bit < 31; bit++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }

        for (int i = 0; i < k; i++) {
            long current = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    current |= (1L << bit);
                    bitCount[bit]--;
                }
            }

            ans = (ans + current * current) % MOD;
        }

        return (int) ans;
    }
}
