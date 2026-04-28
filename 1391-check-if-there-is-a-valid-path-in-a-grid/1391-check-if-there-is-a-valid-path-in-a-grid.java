// class Solution {
//     public boolean hasValidPath(int[][] grid) {
//         int m = grid.length, n = grid[0].length;
//         // Directions for each street type
//         int[][][] street = {
//             {}, // 0 (not used)
//             {{0,-1},{0,1}},        // 1: left, right
//             {{-1,0},{1,0}},        // 2: up, down
//             {{0,-1},{1,0}},        // 3: left, down
//             {{0,1},{1,0}},         // 4: right, down
//             {{0,-1},{-1,0}},       // 5: left, up
//             {{0,1},{-1,0}}         // 6: right, up
//         };
//         boolean[][] visited = new boolean[m][n];
//         Queue<int[]> queue = new LinkedList<>();
//         queue.offer(new int[]{0, 0});
//         visited[0][0] = true;
//         while (!queue.isEmpty()) {
//             int[] curr = queue.poll();
//             int r = curr[0], c = curr[1];
//             // Reached destination
//             if (r == m - 1 && c == n - 1)
//                 return true;
//             int type = grid[r][c];
//             // Try all valid directions for current cell
//             for (int[] d : street[type]) {
//                 int nr = r + d[0];
//                 int nc = c + d[1];
//                 // Check boundaries & visited
//                 if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc])
//                     continue;
//                 int nextType = grid[nr][nc];
//                 // Check reverse connection
//                 for (int[] back : street[nextType]) {
//                     if (nr + back[0] == r && nc + back[1] == c) {
//                         visited[nr][nc] = true;
//                         queue.offer(new int[]{nr, nc});
//                         break;
//                     }
//                 }
//             }
//         }
//         return false;
//     }
// }





class Solution {
    // Directions: Up, Down, Left, Right
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    // Allowed directions for each type
    int[][][] street = {
        {},
        {{0,-1},{0,1}},        // 1
        {{-1,0},{1,0}},        // 2
        {{0,-1},{1,0}},        // 3
        {{0,1},{1,0}},         // 4
        {{0,-1},{-1,0}},       // 5
        {{0,1},{-1,0}}         // 6
    };
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, 0, 0, visited);
    }
    private boolean dfs(int[][] grid, int r, int c, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c])
            return false;
        if (r == m - 1 && c == n - 1)
            return true;
        visited[r][c] = true;
        int type = grid[r][c];
        for (int[] d : street[type]) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                continue;
            int nextType = grid[nr][nc];
            // Check reverse connection
            for (int[] back : street[nextType]) {
                if (nr + back[0] == r && nc + back[1] == c) {
                    if (dfs(grid, nr, nc, visited))
                        return true;
                }
            }
        }
        return false;
    }
}