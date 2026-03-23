class Solution {
    private void dfs(int[][] image, int row, int col, int originalColor, int newColor) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length)
            return;
        if (image[row][col] != originalColor)
            return;
        image[row][col] = newColor;
        dfs(image, row - 1, col, originalColor, newColor);
        dfs(image, row + 1, col, originalColor, newColor);
        dfs(image, row, col - 1, originalColor, newColor);
        dfs(image, row, col + 1, originalColor, newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        // Only fill if colors are different (prevents infinite recursion)
        if (originalColor != color)
            dfs(image, sr, sc, originalColor, color);
        return image;
    }
}