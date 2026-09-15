class Solution {
    public int maxPalindromes(String s, int k) {
        int count = 0;
        int start = 0;
        while (start <= s.length() - k) {
            boolean found = false;
            for (int end = start + k - 1; end < s.length(); end++) {
                for (int left = start; left <= end - k + 1; left++) {
                    String sub = s.substring(left, end + 1);
                    if (isPalindrome(sub)) {
                        count++;
                        start = end + 1;
                        found = true;
                        break;
                    }
                }
                if (found) {
                    break;
                }
            }
            if (!found) {
                break;
            }
        }
        return count;
    }

    public boolean isPalindrome(String s){
        char[] arr = s.toCharArray();
        int low = 0;
        int high = arr.length-1;
        while(low < high){
            if(arr[low] != arr[high]){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}