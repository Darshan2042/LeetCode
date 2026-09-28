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

        List<List<String>> ans = new ArrayList<>();
        for(String key : map.keySet()){
            List<String> curr = map.get(key);
            ans.add(curr);
        }
        return ans;
    }
}