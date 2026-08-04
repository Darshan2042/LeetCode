class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int min = nums[0];
        int max = nums[0];
        for(int num : nums){
            list.add(num);
            if(min > num){
                min = num;
            }
            if(max < num){
                max = num;
            }
        }
        for(int i=min; i<=max; i++){
            if(!list.contains(i)){
                res.add(i);
            }
        }
        return res;
    }
}