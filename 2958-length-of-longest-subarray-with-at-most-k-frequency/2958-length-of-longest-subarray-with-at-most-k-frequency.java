class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int freq = map.getOrDefault(nums[i], 0) + 1;
            map.put(nums[i], freq);
            while (freq > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (nums[l] == nums[i]) {
                    freq--;
                }
                l++;
            }
            int length = i - l + 1;
            ans = Math.max(ans, length);
        }
        return ans;
    }
}