class Solution {
    public boolean predictTheWinner(int[] nums) {
        return solve(nums, 0, nums.length - 1, 0, 0, true);
    }
    public boolean solve(int[] nums, int left, int right,int p1, int p2, boolean turn) {
        if (left > right) {
            return p1 >= p2;
        }
        if (turn) {
            boolean takeLeft =solve(nums, left + 1, right, p1 + nums[left], p2, false);
            boolean takeRight =solve(nums, left, right - 1, p1 + nums[right], p2, false);
            return takeLeft || takeRight;
        } else {
            boolean takeLeft = solve(nums, left + 1, right, p1, p2 + nums[left], true);
            boolean takeRight =solve(nums, left, right - 1, p1, p2 + nums[right], true);
            return takeLeft && takeRight;
        }
    }
}