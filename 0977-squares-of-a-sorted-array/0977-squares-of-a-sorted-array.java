class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int index = nums.length-1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];
            if(leftSquare < rightSquare){
                arr[index] = rightSquare;
                right--;
                index--;
            } 
            else{
                arr[index] = leftSquare;
                left++;
                index--;
            }
        }
        return arr;
    }
}