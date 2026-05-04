class Solution {
    public void rotate(int[][] matrix) {
        /**
        90 = transpose + reverse row
        180 = reverse row + reverse column
        270 = transpose + reverse col
        */
        int n = matrix.length;
        int[][] temp = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                temp[j][i] = matrix[i][j];
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = t;
            }
        }
    }
}