class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            indegree[v]++;
        }
        
        boolean[] suspicious = new boolean[n];

        dfs(k, graph, suspicious, indegree);
        for (int i = 0; i < n; i++) {
            if (suspicious[i] && indegree[i] > 0) {
                List<Integer> ans = new ArrayList<>();
                for (int j = 0; j < n; j++)
                    ans.add(j);
                return ans;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i])
                ans.add(i);
        }
        return ans;
    }

    private void dfs(int node, List<Integer>[] graph,boolean[] suspicious, int[] indegree) {
        suspicious[node] = true;
        for (int next : graph[node]) {
            indegree[next]--;
            if (!suspicious[next]) {
                dfs(next, graph, suspicious, indegree);
            }
        }
    }
}