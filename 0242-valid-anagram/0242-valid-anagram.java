class Solution {
    public boolean isAnagram(String s, String t) {
        int len_s = s.length();
        int len_t = t.length();
        int[] result = new int[26];
        for(int i=0 ; i<s.length() ; i++){
            result[s.charAt(i) - 'a']++;
        }
        for(int i=0 ; i<t.length() ; i++){
            result[t.charAt(i) - 'a']--;
        }
        for(int count : result){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}