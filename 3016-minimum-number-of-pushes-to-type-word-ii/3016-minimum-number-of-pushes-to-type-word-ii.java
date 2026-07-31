class Solution {
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<word.length(); i++){
            char ch = word.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        int ans = 0;
        for(int i=0 ; i<list.size(); i++){
            int num = list.get(i);
            if(i < 8){
                ans += num * 1;
            }
            else if(i < 16){
                ans +=num * 2;
            }
            else if(i < 24){
                ans +=num * 3;
            }
            else{
                ans +=num * 4;
            }
        }
        return ans;


    }
}