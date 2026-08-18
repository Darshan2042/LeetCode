class Solution {
    public int missingNumber(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int largest = 0;
        for(int num : nums){
            arr.add(num);
            if(num > largest){
                largest = num;
            }
        }

        for(int i=0; i<=largest+1; i++){
            if(!arr.contains(i)){
                return i;
            }
        }
        return -1;
    }
}