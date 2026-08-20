class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length-1;i++){
            for(int j=i+1;j<matrix[i].length;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0;i<matrix.length;i++){
            reverse(matrix[i]);
        }
    }

    public void reverse(int[] nums){
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

}