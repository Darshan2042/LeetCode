class Solution {
    public int mostWordsFound(String[] sentences) {
        int max = 0;
        for(String curr : sentences){
            String[] arr = curr.split(" ");
            int n = arr.length;
            if(n > max){
                max = n;
            }
        }
        return max;
    }
}