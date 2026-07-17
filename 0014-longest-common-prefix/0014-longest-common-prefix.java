class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n == 0){
            return "";
        }
        String longest = strs[0];
        for(int i=1 ; i<strs.length ; i++){
            int j = 0;
            String curr = strs[i];
            while(j < curr.length() && j < longest.length() && curr.charAt(j) == longest.charAt(j)){
                j++;
            }

            longest = longest.substring(0,j);
        }
        return longest;
        
    }
}