class Solution {
    public int[] resultArray(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for(int i=2; i<nums.length; i++){
            int last = arr1.size()-1;
            int last2 = arr2.size()-1;
            if(arr1.get(last) > arr2.get(last2)){
                arr1.add(nums[i]);
            }
            else{
                arr2.add(nums[i]);
            }
        }
        int[] res = new int[arr1.size() + arr2.size()];
        int index = 0;
        for(int num : arr1){
            res[index++] = num;
        }
        for(int num : arr2){
            res[index++] = num;
        }
        return res;
    }

}