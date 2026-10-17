import java.util.*;

class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] idx = new int[n];
        int[] sum = new int[n];

        for (int i = 0; i < n; i++) {
            idx[i] = i;
            sum[i] = digitSum(nums[i]);
        }

        Integer[] order = new Integer[n];

        for (int i = 0; i < n; i++) {
            order[i] = i;
        }

        Arrays.sort(order, (a, b) -> {
            if (sum[a] != sum[b]) {
                return Integer.compare(sum[a], sum[b]);
            }
            return Integer.compare(nums[a], nums[b]);
        });

        int[] target = new int[n];

        for (int i = 0; i < n; i++) {
            target[order[i]] = i;
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            int j = i;
            int cycleSize = 0;

            while (!visited[j]) {
                visited[j] = true;
                j = target[j];
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += cycleSize - 1;
            }
        }

        return swaps;
    }

    private int digitSum(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
