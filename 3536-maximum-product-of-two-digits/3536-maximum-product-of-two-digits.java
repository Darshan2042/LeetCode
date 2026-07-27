class Solution {
    public int maxProduct(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        while(n != 0){
            int digit = n % 10;
            arr.add(digit);
            n /= 10;
        }
        Collections.sort(arr);
        int len = arr.size();
        return arr.get(len-1) * arr.get(len-2);
    }
}