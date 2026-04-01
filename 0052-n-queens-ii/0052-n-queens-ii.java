class Solution {
    private int count = 0;
    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();        // Columns with queens
        Set<Integer> diag1 = new HashSet<>();       // Diagonals (row - col)
        Set<Integer> diag2 = new HashSet<>();       // Anti-diagonals (row + col)
        backtrack(0, n, cols, diag1, diag2);
        return count;
    }
    private void backtrack(int row, int n, Set<Integer> cols, 
                           Set<Integer> diag1, Set<Integer> diag2) {
        // Base case: All queens placed
        if (row == n) {
            count++;
            return;
        }
        // Try placing queen in each column of current row
        for (int col = 0; col < n; col++) {
            int d1 = row - col;     // Diagonal identifier
            int d2 = row + col;     // Anti-diagonal identifier
            // Check if position is safe
            if (cols.contains(col) || diag1.contains(d1) || diag2.contains(d2))
                continue;
            // Place queen
            cols.add(col);
            diag1.add(d1);
            diag2.add(d2);
            // Recurse to next row
            backtrack(row + 1, n, cols, diag1, diag2);
            // Remove queen (backtrack)
            cols.remove(col);
            diag1.remove(d1);
            diag2.remove(d2);
        }
    }
}