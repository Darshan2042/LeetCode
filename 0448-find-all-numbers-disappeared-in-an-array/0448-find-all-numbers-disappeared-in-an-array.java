class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        HashSet<Integer> arr = new HashSet<>();
        for(int num : nums){
            arr.add(num);
        }
        // int max = 0;
        // for(int i=0 ; i<nums.length ;i++){
        //     if(nums[i] > max){
        //         max= nums[i];
        //     }
        // }
        for(int i=1 ;i<nums.length+1 ; i++){
            if(!arr.contains(i)){
                list.add(i);
            }
        }
        return list;
    }
}