class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) < s.charAt(i-1)){
                sorted = false;
                break;
            }
        }

        if(sorted) return 0;
        if(n == 2) return -1;
        char min = 'z';
        char max = 'a';
        int mincount = 0;
        int maxcount = 0;
        for(char ch : s.toCharArray()){
            min = (char)Math.min(min,ch);
            max = (char)Math.max(max,ch);
        }
        for (char ch : s.toCharArray()) {
            if (ch == min) mincount++;
            if (ch == max) maxcount++;
        }

        if(s.charAt(0) == min || s.charAt(n-1) == max){
            return 1;
        }

        if (s.charAt(0) == max && s.charAt(n - 1) == min
                && mincount == 1 && maxcount == 1)
            return 3;

        return 2;
    }
}