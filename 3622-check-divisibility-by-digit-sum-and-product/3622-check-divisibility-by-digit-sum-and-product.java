class Solution {
    public boolean checkDivisibility(int n) {
        int org = n;
        int sum = 0;
        int pro = 1;

        while(n != 0){
            int digit = n % 10;
            n /= 10;

            sum += digit;
            pro *= digit;
        }

        sum += pro;
        return org % sum == 0;
    }
}