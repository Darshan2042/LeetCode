class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        if(pattern.length() != words.length){
            return false;
        }

        HashMap<Character,String> map1 = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();

        for(int i=0; i< pattern.length(); i++){
            char ch = pattern.charAt(i);
            String curr = words[i];

            if(map1.containsKey(ch) && !map1.get(ch).equals(curr)){
                return false;
            }

            if(map2.containsKey(curr) && map2.get(curr) != ch){
                return false;
            }

            map1.put(ch,curr);
            map2.put(curr,ch);
        }
        return true;

    }
}