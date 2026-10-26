class Solution {
    public String longestPalindrome(String s) {
        String lps = "";
        for(int i=0; i<s.length(); i++){
            int left = i;
            int right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }
            String ans = s.substring(left+1, right);
            if(ans.length() > lps.length()){
                lps = ans;
            }

            int left1 = i;
            int right1 = i+1;
            while(left1 >= 0 && right1 < s.length() && s.charAt(left1) == s.charAt(right1)){
                left1--;
                right1++;
            }

            String ans1 = s.substring(left1+1,right1);
            if(ans1.length() > lps.length()){
                lps = ans1;
            }
        }
        return lps;
    }
}