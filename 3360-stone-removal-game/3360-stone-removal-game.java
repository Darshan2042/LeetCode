class Solution {
    public boolean canAliceWin(int n) {
        int remove = 10;
        boolean aliceturn = true;
        while(n >= remove){
            n -= remove;
            if(aliceturn){
                aliceturn = false;
            }else{
                aliceturn = true;
            }
            remove--;
        }
        return !aliceturn;
    }
}