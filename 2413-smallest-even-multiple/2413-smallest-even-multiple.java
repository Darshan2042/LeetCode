class Solution {
    public int smallestEvenMultiple(int n) {
        int org = n;
        if(n % n == 0 && n % 2 == 0){
            return n;
        }
        while(true){
            n++;
            if(n % org == 0 && n % 2 ==0 ){
                return n;
            }
        }
    }
}