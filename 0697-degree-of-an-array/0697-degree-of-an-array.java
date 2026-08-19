class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int degree = 0;
        for (int key : map.keySet()) {
            degree = Math.max(degree, map.get(key));
        }
        int answer = nums.length;
        for (int key : map.keySet()) {
            if (map.get(key) == degree) {
                int l = 0;
                int r = nums.length - 1;
                while (nums[l] != key) {
                    l++;
                }
                while (nums[r] != key) {
                    r--;
                }
                answer = Math.min(answer, r - l + 1);
            }
        }
        return answer;
    }
}