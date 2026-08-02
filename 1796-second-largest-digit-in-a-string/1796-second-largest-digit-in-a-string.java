class Solution {
    public int secondHighest(String s) {
        char[] arr = s.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for(char ch : arr){
            if(Character.isDigit(ch)){
                list.add(ch);
            }
        }
        int first = -1;
        int second = -1;
        for(int i=0; i<list.size(); i++){
            char curr = list.get(i);
            int num = curr - '0';
            if(num > first){
                second = first;
                first = num;
            }
            else if(num > second && num != first){
                second = num;
            }
        }
        return second;
    }
} 