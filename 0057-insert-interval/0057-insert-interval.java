class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[1] < newInterval[0]) {
                ans.add(interval);
            }
            else if (interval[0] > newInterval[1]) {
                ans.add(newInterval);
                for (int j = i; j < intervals.length; j++) {
                    ans.add(intervals[j]);
                }
                return ans.toArray(new int[ans.size()][]);
            }
            else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        ans.add(newInterval);
        return ans.toArray(new int[ans.size()][]);
    }
}