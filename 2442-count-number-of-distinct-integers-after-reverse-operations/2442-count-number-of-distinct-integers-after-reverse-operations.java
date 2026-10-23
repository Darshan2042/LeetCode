class Solution {
    public int countDistinctIntegers(int[] nums) {
        int[] arr = new int[nums.length*2];
        int index = 0;
        for(int num : nums){
            arr[index] = num;
            index++;
        }
        for(int num : nums){
            arr[index] = reverse(num);
            index++;
        }
        return hashset(arr);
    }

    public int reverse(int x){
        int rev = 0;
        while(x != 0){
            int digit = x % 10;
            rev = rev * 10 + digit;
            x /= 10;
        }
        return rev;
    }

    public int hashset(int[] nums){
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        return set.size();
    }
}