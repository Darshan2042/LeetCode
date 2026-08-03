class Solution {
    public int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> even = new ArrayList<>();
        ArrayList<Integer> odd =  new ArrayList<>();
        for(int num : nums){
            if(num > 0){
                even.add(num);
            }
            else{
                odd.add(num);
            }
        }
        int p = 0;
        int n = 0;
        int[] res = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            if (i % 2 == 0) {
                res[i] = even.get(p++);
            } else {
                res[i] = odd.get(n++);
            }
        }
        return res;
    }
}