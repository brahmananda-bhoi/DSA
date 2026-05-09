import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;
        for (int layer = 0; layer < layers; layer++)
            rotateLayer(grid, layer, k);
        return grid;
    }
    private void rotateLayer(int[][] grid, int layer, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int top = layer;
        int bottom = m - 1 - layer;
        int left = layer;
        int right = n - 1 - layer;
        List<Integer> elements = new ArrayList<>();
        for (int col = left; col <= right; col++)
            elements.add(grid[top][col]);
        for (int row = top + 1; row <= bottom; row++)
            elements.add(grid[row][right]);
        if (bottom > top) {
            for (int col = right - 1; col >= left; col--)
                elements.add(grid[bottom][col]);
        }
        if (right > left) {
            for (int row = bottom - 1; row > top; row--)
                elements.add(grid[row][left]);
        }
        int size = elements.size();
        k = k % size;
        int index = k;
        for (int col = left; col <= right; col++) {
            grid[top][col] = elements.get(index % size);
            index++;
        }
        for (int row = top + 1; row <= bottom; row++) {
            grid[row][right] = elements.get(index % size);
            index++;
        }
        if (bottom > top) {
            for (int col = right - 1; col >= left; col--) {
                grid[bottom][col] = elements.get(index % size);
                index++;
            }
        }
        if (right > left) {
            for (int row = bottom - 1; row > top; row--) {
                grid[row][left] = elements.get(index % size);
                index++;
            }
        }
    }
}