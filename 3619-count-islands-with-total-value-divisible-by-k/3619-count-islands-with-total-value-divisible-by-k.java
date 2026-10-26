
class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    long sum = dfs(grid, visited, i, j);
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private long dfs(int[][] grid, boolean[][] visited,
                     int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if (row < 0 || row >= m ||
            col < 0 || col >= n ||
            grid[row][col] == 0 ||
            visited[row][col]) {
            return 0;
        }
        visited[row][col] = true;
        long sum = grid[row][col];
        sum += dfs(grid, visited, row - 1, col);
        sum += dfs(grid, visited, row + 1, col);
        sum += dfs(grid, visited, row, col - 1);
        sum += dfs(grid, visited, row, col + 1);
        return sum;
    }
}
