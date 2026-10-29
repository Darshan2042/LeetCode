class Solution {
    List<Integer>[] adj;
    int[] parent, depth, size, heavy, head, pos;
    int[] segTree;
    int timer;
    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        char[] chars = s.toCharArray();
        parent = new int[n];
        depth = new int[n];
        size = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];
        Arrays.fill(parent, -1);
        Arrays.fill(heavy, -1);
        dfs1(0, -1);
        timer = 0;
        decompose(0, 0);
        segTree = new int[4 * n];
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[pos[i]] = 1 << (chars[i] - 'a');
        }
        build(1, 0, n - 1, values);
        List<Boolean> answer = new ArrayList<>();
        for (String query : queries) {
            String[] parts = query.split("\\s+");
            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                chars[u] = c;
                update(
                    1, 0, n - 1,
                    pos[u], 1 << (c - 'a')
                );

            } else {

                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = queryPath(u, v);

                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    // Calculate subtree sizes and heavy child.
    private void dfs1(int u, int p) {
        parent[u] = p;
        size[u] = 1;

        int maxSize = 0;

        for (int v : adj[u]) {
            if (v == p) {
                continue;
            }

            depth[v] = depth[u] + 1;

            dfs1(v, u);

            size[u] += size[v];

            if (size[v] > maxSize) {
                maxSize = size[v];
                heavy[u] = v;
            }
        }
    }

    // Assign positions to nodes using HLD.
    private void decompose(int u, int h) {
        head[u] = h;
        pos[u] = timer++;

        if (heavy[u] != -1) {
            decompose(heavy[u], h);
        }

        for (int v : adj[u]) {
            if (v == parent[u] || v == heavy[u]) {
                continue;
            }

            decompose(v, v);
        }
    }

    // Build segment tree.
    private void build(int node, int l, int r, int[] values) {
        if (l == r) {
            segTree[node] = values[l];
            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid, values);
        build(node * 2 + 1, mid + 1, r, values);

        segTree[node] =
            segTree[node * 2] ^ segTree[node * 2 + 1];
    }

    // Update a character at one node.
    private void update(
            int node, int l, int r, int index, int value) {

        if (l == r) {
            segTree[node] = value;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        segTree[node] =
            segTree[node * 2] ^ segTree[node * 2 + 1];
    }

    // XOR of a segment-tree range.
    private int rangeQuery(
            int node, int l, int r, int ql, int qr) {

        if (qr < l || r < ql) {
            return 0;
        }

        if (ql <= l && r <= qr) {
            return segTree[node];
        }

        int mid = l + (r - l) / 2;

        return rangeQuery(node * 2, l, mid, ql, qr)
             ^ rangeQuery(node * 2 + 1, mid + 1, r, ql, qr);
    }

    // XOR mask of the complete path u -> v.
    private int queryPath(int u, int v) {
        int mask = 0;

        while (head[u] != head[v]) {

            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            mask ^= rangeQuery(
                1, 0, pos.length - 1,
                pos[head[u]], pos[u]
            );

            u = parent[head[u]];
        }

        int left = Math.min(pos[u], pos[v]);
        int right = Math.max(pos[u], pos[v]);

        mask ^= rangeQuery(
            1, 0, pos.length - 1, left, right
        );

        return mask;
    }
}
