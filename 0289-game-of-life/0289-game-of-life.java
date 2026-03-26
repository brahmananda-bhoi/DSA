class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] dirs = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbors = countLiveNeighbors(board, i, j, m, n, dirs);
                // Currently alive
                if (board[i][j] == 1) {
                    // Survives with 2 or 3 neighbors
                    if (liveNeighbors == 2 || liveNeighbors == 3)
                        board[i][j] = 3; // Alive → Alive
                    // Otherwise stays 1 (Alive → Dead)
                }
                // Currently dead
                else {
                    // Becomes alive with exactly 3 neighbors
                    if (liveNeighbors == 3)
                        board[i][j] = 2; // Dead → Alive
                    // Otherwise stays 0 (Dead → Dead)
                }
            }
        }
        // Second pass: Extract new state
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                board[i][j] /= 2;
        }
    }
    private int countLiveNeighbors(int[][] board, int row, int col, int m, int n, int[][] dirs) {
        int count = 0;
        for (int[] dir : dirs) {
            int ni = row + dir[0];
            int nj = col + dir[1];
            if (ni >= 0 && ni < m && nj >= 0 && nj < n)
                count += board[ni][nj] % 2;
        }
        return count;
    }
}