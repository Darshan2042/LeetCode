class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> set = new TreeSet<>();
        for(int i=0; i<digits.length; i++){
            if(digits[i] == 0){
                continue;
            }

            for(int j=0; j<digits.length; j++){
                if(j == i){
                    continue;
                }
                for(int k=0; k<digits.length; k++){
                    if(k == i || k==j){
                        continue;
                    }

                    if(digits[k] % 2 != 0){
                        continue;
                    }

                    int num = digits[i] * 100 + digits[j] * 10 + digits[k];
                    set.add(num);
                }
            }
        }
        int[] res = new int[set.size()];
        int i = 0;
        for(int num : set){
            res[i++] = num;
        }
        return res;
    }
}