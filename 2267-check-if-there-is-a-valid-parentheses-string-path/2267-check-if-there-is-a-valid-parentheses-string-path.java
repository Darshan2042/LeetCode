class Solution {
    int rows;
    int cols;
    Boolean[][][] memo;
    public boolean hasValidPath(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        if ((rows + cols - 1) % 2 != 0) {
            return false;
        }
        if (grid[0][0] != '(') {
            return false;
        }
        if (grid[rows - 1][cols - 1] != ')') {
            return false;
        }
        memo = new Boolean[rows][cols][rows + cols];
        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int row, int col, int balance) {
        if (grid[row][col] == '(') {
            balance++;
        } else {
            balance--;
        }
        if (balance < 0) {
            return false;
        }
        int remaining = (rows - 1 - row) + (cols - 1 - col);
        if (balance > remaining) {
            return false;
        }
        if (row == rows - 1 && col == cols - 1) {
            return balance == 0;
        }
        if (memo[row][col][balance] != null) {
            return memo[row][col][balance];
        }
        boolean down = false;
        boolean right = false;
        if (row + 1 < rows) {
            down = dfs(grid, row + 1, col, balance);
        }
        if (col + 1 < cols) {
            right = dfs(grid, row, col + 1, balance);
        }
        memo[row][col][balance] = down || right;
        return memo[row][col][balance];
    }
}