class Solution {
    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                // if(!visited[i][j]){
                //     if(dfs(grid, i ,j , -1, -1, visited))
                //         return true;
                // }
                if(!visited[i][j] && dfs(grid, i ,j , -1, -1, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] grid, int row, int col, int pRow, int pCol, boolean[][] visited){
        visited[row][col] = true;
        for(int[] dir : directions){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length)
                continue;
            if(grid[row][col] != grid[newRow][newCol])
                continue;
            if(newRow == pRow && newCol == pCol)
                continue;
            if(visited[newRow][newCol])
                return true;
            if(dfs(grid, newRow, newCol, row, col, visited))
                return true;
        }
        return false;
    }
}