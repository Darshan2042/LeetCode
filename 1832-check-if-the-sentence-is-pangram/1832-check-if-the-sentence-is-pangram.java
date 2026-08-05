class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        for(int i=0; i<sentence.length(); i++){
            arr[sentence.charAt(i) - 'a']++;
        }
        for(int num : arr){
            if(num == -1 || num == 0){
                return false;
            }
        }
        return true;
    }
}