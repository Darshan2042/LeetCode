class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] costDp = new int[m+1][n+1];
        for(int i=1 ; i<=m ; ++i){
            costDp[i][0] = i;
        }
        for(int i=1 ; i<=n ; ++i){
            costDp[0][i] = i;
        }

        for(int i=1 ;i <=m ; ++i){
            for(int j = 1 ; j<=n ; ++j){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    costDp[i][j] = costDp[i-1][j-1];
                }
                else{
                    int topleft = costDp[i-1][j-1];
                    int top = costDp[i-1][j];
                    int left = costDp[i][j-1];
                    costDp[i][j] = Math.min(topleft,Math.min(top,left))+1;
                }
            }
        }
        return costDp[m][n];
    }
}