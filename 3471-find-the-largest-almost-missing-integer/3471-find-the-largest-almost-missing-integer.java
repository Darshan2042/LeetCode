class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int n = nums.length;
        if(k == 1){
            int largest = -1;
            for(int num : map.keySet()){
                if(map.get(num) == 1 && num > largest){
                    largest = num;
                }
            }
            return largest;
        }
        else if(k == n){
            int largest = -1;
            for(int num : nums){
                if(num > largest){
                    largest = num;
                }
            }
            return largest;
        }
            int largest = -1;
            if(map.get(nums[0]) == 1){
                largest = nums[0];
            }

            if(map.get(nums[n-1]) == 1){
                if(nums[n-1] > largest){
                    largest = nums[n-1];
                }
            }
            return largest;
    }
}