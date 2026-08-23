class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftsum = 0;
        int rightsum = 0;
        int left = 0;
        int right = 0;
        int mid = n/2;
        for(int i=0; i<mid; i++){
            int digit = num.charAt(i) - '0';
            if(num.charAt(i) == '?'){
                left++;
            }
            else{
                leftsum += digit;
            }
        }

        for(int i=mid; i<n; i++){
            int digit = num.charAt(i) - '0';
            if(num.charAt(i) == '?'){
                right++;
            }
            else{
                rightsum += digit;
            }
        }

        int sum = right + left;
        if(sum % 2 == 1){
            return true;
        }

        int d = leftsum - rightsum;
        int diff = right - left;

        return d != (diff * 9) / 2;
    }
}