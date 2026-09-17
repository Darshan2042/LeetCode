class Solution {

    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        ArrayList<Integer> best = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            best.add(Integer.MAX_VALUE);
        }

        int left = 0;
        int sum = 0;

        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }

            // Carry forward previous minimum
            if (right > 0) {
                best.set(right, best.get(right - 1));
            }

            // Found subarray
            if (sum == target) {

                int length = right - left + 1;

                // Check if there is a previous non-overlapping subarray
                if (left > 0 &&
                    best.get(left - 1) != Integer.MAX_VALUE) {

                    answer = Math.min(
                        answer,
                        length + best.get(left - 1)
                    );
                }

                // Store the shortest subarray ending at right
                best.set(
                    right,
                    Math.min(best.get(right), length)
                );
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}