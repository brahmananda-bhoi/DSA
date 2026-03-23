class Solution {
    private void dfs(int row, int col, char[][] grid, boolean[][] vis) {
        // Boundary checks
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
            return;
        // If water or already visited, return
        if (grid[row][col] == '0' || vis[row][col])
            return;
        vis[row][col] = true;
        // Explore all 4 directions
        dfs(row - 1, col, grid, vis);  // Up
        dfs(row + 1, col, grid, vis);  // Down
        dfs(row, col - 1, grid, vis);  // Left
        dfs(row, col + 1, grid, vis);  // Right
    }
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] vis = new boolean[rows][cols];
        int islands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    dfs(i, j, grid, vis);
                    islands++;
                }
            }
        }
        return islands;
    }
}