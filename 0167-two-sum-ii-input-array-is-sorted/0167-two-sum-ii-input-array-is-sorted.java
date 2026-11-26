class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int low = 0;
        int high = numbers.length-1;
        while(low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                ans[0] = low+1;
                ans[1] = high+1;
                low++;
                high--;
            }
            else if(sum < target){
                low++;
            }
            else{
                high--;
            }
        }
        return ans;
    }
}