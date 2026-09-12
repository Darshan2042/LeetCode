class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] a = new int[26];

        for(char ch : magazine.toCharArray()){
            a[ch - 'a']++;
        }

        for(char ch : ransomNote.toCharArray()){
            if(a[ch - 'a'] == 0){
                return false;
            }

            a[ch - 'a']--;
        }
        return true;
    }
}