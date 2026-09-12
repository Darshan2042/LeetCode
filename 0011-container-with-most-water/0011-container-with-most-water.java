class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int ans = 0;
        while(left < right){
            int l = right - left;
            int w = Math.min(height[left],height[right]);
            int a = l * w;
            ans = Math.max(a , ans);
            if(height[left] > height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return ans;
    }
}