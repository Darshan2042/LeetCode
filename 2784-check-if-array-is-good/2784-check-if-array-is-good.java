class Solution {
    public boolean isGood(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
            if(num > max){
                max = num;
            }
        }
        if(nums.length != max+1){
            return false;
        }
        if(map.get(max) != 2){
            return false;
        }
        for (int i = 1; i < max; i++) {
            if (map.getOrDefault(i, 0) != 1) {
                return false;
            }
        }
        return true;
    }
}