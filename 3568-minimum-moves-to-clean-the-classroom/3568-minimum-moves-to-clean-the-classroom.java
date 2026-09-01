class Solution {
    public int minMoves(String[] grid, int energy) {
        int m = grid.length, n = grid[0].length();
        int sr = 0, sc = 0, k = 0;
        int[][] id = new int[m][n];
        for (int[] row : id) Arrays.fill(row, -1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == 'S') {
                    sr = i;
                    sc = j;
                } else if (grid[i].charAt(j) == 'L') {
                    id[i][j] = k++;
                }
            }
        }
        int target = (1 << k) - 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc, energy, 0, 0});
        boolean[][][][] vis = new boolean[m][n][energy + 1][1 << k];
        vis[sr][sc][energy][0] = true;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int[] a = q.poll();
            int r = a[0], c = a[1];
            int e = a[2], mask = a[3], moves = a[4];
            if (mask == target) return moves;
            if (e == 0) continue;
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (grid[nr].charAt(nc) == 'X') continue;
                int ne = e - 1;
                int nm = mask;
                char ch = grid[nr].charAt(nc);
                if (ch == 'L') nm |= 1 << id[nr][nc];
                if (ch == 'R') ne = energy;
                if (!vis[nr][nc][ne][nm]) {
                    vis[nr][nc][ne][nm] = true;
                    q.add(new int[]{nr, nc, ne, nm, moves + 1});
                }
            }
        }
        return -1;
    }
}