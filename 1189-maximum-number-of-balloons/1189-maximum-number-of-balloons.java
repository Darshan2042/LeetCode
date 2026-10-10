class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : text.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        String s = "balloon";
        int min = Integer.MAX_VALUE;
        for(char ch : s.toCharArray()){
            int num = map.getOrDefault(ch,0);
            if (ch == 'l' || ch == 'o') {
                num /= 2;
            }
            if(num < min){
                min =  num;
            }
        }
        return min;
    }
}