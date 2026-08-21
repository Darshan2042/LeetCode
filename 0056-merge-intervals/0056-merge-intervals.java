class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        List<int []> list = new ArrayList<>();

        int[] st = intervals[0];
        list.add(st);

        for(int[] curr : intervals){
            if(curr[0] <= st[1]){
                st[1] = Math.max(st[1] , curr[1]);
            }
            else{
                st = curr;
                list.add(st);
            }
        }
        return list.toArray(new int[list.size()][]);

    }
}