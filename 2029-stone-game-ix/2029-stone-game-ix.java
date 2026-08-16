class Solution {
    public boolean stoneGameIX(int[] stones) {
        int z = 0;
        int o = 0;
        int t = 0;
        for(int num : stones){
            if(num % 3 == 0){
                z++;
            }
            else if(num % 3 == 2){
                t++;
            }
            else{
                o++;
            }
        }

        int diff = Math.abs(o - t);
        if(z % 2 == 0){
            if (o > 0 && t > 0) {
                return true;
            }
    return false;
        }
        else{
            if(diff > 2){
                return true;
            }
            return false;
        }
    }
}