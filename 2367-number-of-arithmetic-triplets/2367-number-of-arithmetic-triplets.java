class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            int left = i - 1;
            int right = i + 1;

            while (left >= 0 && right < nums.length) {
                int leftDiff = nums[i] - nums[left];
                int rightDiff = nums[right] - nums[i];

                if (leftDiff == diff && rightDiff == diff) {
                    count++;
                    break;
                }

                if (leftDiff < diff) {
                    left--;
                } else if (leftDiff > diff) {
                    break;
                }

                if (rightDiff < diff) {
                    right++;
                } else if (rightDiff > diff) {
                    break;
                }
            }
        }

        return count;
    }
}