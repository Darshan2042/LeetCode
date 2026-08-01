class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int mapSize = map.size();
        HashSet<Integer> set = new HashSet<>();
        for(int key : map.keySet()){
            set.add(map.get(key));
        }
        int setSize = set.size();
        return mapSize == setSize;
    }
}