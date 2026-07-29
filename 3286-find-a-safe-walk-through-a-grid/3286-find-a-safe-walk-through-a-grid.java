class Solution {
    int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private boolean dfs(int row, int col, List<List<Integer>> grid, boolean[][] vis, int h){
        if(grid.get(row).get(col) == 1)
            h--;
        if(h <= 0)
            return false;
        if(row == grid.size()-1 && col == grid.get(0).size()-1)
            return true;
        vis[row][col] = true;
        for(int[] dir : dirs){
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if(newRow >= 0 && newCol >= 0 && newRow < grid.size() && newCol < grid.get(0).size() && !vis[newRow][newCol]){
                if(dfs(newRow, newCol, grid, vis, h))
                    return true;
                vis[newRow][newCol] = false;
            }
        }
        return false;
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size(), n=grid.get(0).size();
        boolean[][] vis = new boolean[m][n];
        return dfs(0, 0, grid, vis, health);
    }
}