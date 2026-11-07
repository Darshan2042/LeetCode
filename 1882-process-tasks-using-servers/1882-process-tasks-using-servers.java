class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;
        int[] ans = new int[m];
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        );
        PriorityQueue<int[]> busy = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                if (a[1] != b[1]) {
                    return a[1] - b[1];
                }
                return a[2] - b[2];
            }
        );
        for (int i = 0; i < n; i++) {
            available.offer(new int[]{servers[i], i});
        }
        long currentTime = 0;
        for (int i = 0; i < m; i++) {
            currentTime = Math.max(currentTime, i);
            while (!busy.isEmpty() &&
                   busy.peek()[0] <= currentTime) {
                int[] server = busy.poll();
                available.offer(
                    new int[]{server[1], server[2]}
                );
            }
            if (available.isEmpty()) {
                currentTime = busy.peek()[0];
                while (!busy.isEmpty() &&
                       busy.peek()[0] <= currentTime) {
                    int[] server = busy.poll();
                    available.offer(
                        new int[]{server[1], server[2]}
                    );
                }
            }
            int[] server = available.poll();
            int weight = server[0];
            int index = server[1];
            ans[i] = index;
            long finishTime = currentTime + tasks[i];
            busy.offer(new int[]{
                (int) finishTime,
                weight,
                index
            });
        }
        return ans;
    }
}
