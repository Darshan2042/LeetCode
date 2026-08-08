class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            if(map.containsKey(sorted)){
                map.get(sorted).add(str);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sorted,list);
            }
        }
        return new ArrayList<>(map.values());
    }
}