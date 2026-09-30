class Solution {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        HashMap<String,List<String>> map = new HashMap<>();
        map.put("type",new ArrayList<>());
        map.put("color",new ArrayList<>());
        map.put("name",new ArrayList<>());
        for(List<String> list : items){
            map.get("type").add(list.get(0));
            map.get("color").add(list.get(1));
            map.get("name").add(list.get(2));
        }
        int count = 0;
        if(map.containsKey(ruleKey)){
            List<String> arr = map.get(ruleKey);
            for(String  a : arr){
                if(a.equals(ruleValue)){
                    count++;
                }

            }
        }
    return count;
    }
}