class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] arr = paragraph.toLowerCase().split("[!?',;. ]+");
        HashMap<String,Integer> map = new HashMap<>();
        for(String ele : arr){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(String e : banned){
            if(map.containsKey(e)){
                map.remove(e);
            }
        }
        String t = null;
        int max = 0;
        for(String key : map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                t = key;
            }
        }
        return t;
    }
}