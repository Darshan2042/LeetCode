class Solution {
    public int getMinDistance(int[] nums, int target, int start) {

        int left = start;
        int right = start;

        int leftCount = 0;
        int rightCount = 0;

        while (left >= 0 || right < nums.length) {

            if (left >= 0 && nums[left] == target) {
                return leftCount;
            }

            if (right < nums.length && nums[right] == target) {
                return rightCount;
            }

            if (left >= 0) {
                left--;
                leftCount++;
            }

            if (right < nums.length) {
                right++;
                rightCount++;
            }
        }

        return -1;
    }
}