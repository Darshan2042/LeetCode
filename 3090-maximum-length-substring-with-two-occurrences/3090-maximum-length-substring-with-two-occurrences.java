class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for(int right = 0; right<s.length(); right++){
            char ch = s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch) > 2){
                char l = s.charAt(left);
                map.put(l,map.get(l)-1);
                left++;
            }

            ans = Math.max(ans, right-left+1);
        }
        return ans;
    }
}