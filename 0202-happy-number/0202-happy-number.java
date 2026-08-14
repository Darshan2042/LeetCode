class Solution {
    public boolean isHappy(int n) {
        while(n != 1 && n != 4){ //  n != 4  beacuse it 4 create a loop 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4
            int sum = 0;
            while(n != 0){
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }
        return n == 1;
    }
}