class Solution {
    public int lastStoneWeight(int[] stones) {
        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones){
            pq.add(num);
        }
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            if(first != second){
                pq.add(first - second);
            }
        }
        if(pq.isEmpty()){
            return 0;
        }
        else{
            return pq.poll();
        }
    }
}