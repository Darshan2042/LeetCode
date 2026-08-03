class Solution {
    public String frequencySort(String s) {
        char[] arr = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : arr){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(char ch : map.keySet()){
            pq.add(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            char ch = pq.poll();
            int num = map.get(ch);
            while(num-- > 0){
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}