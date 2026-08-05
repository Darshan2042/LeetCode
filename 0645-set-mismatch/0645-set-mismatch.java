class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            if(set.contains(num)){
                res[0] = num;
            }else{
                set.add(num);
            }
        }
        for(int i=1; i<nums.length+1; i++){
            if(!set.contains(i)){
                res[1] = i;
                break;
            }
        }
        return res;
    }
}