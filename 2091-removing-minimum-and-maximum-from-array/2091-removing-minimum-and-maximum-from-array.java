class Solution {
    public int minimumDeletions(int[] nums) {
      int n = nums.length;
      int min = 0;
      int max = 0;
      for(int i=0; i<nums.length; i++){
        if(nums[i] > nums[max]){
            max = i;
        }
        if(nums[i] < nums[min]){
            min = i;
        }
      }
      int a = Math.max(min, max) + 1;
      int b = n - Math.min(min, max);
      int c = Math.min(min, max) + 1 + n - Math.max(min, max);
      return Math.min(Math.min(a, b), c);
    }
}