class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>(); 
        int top = 0, bottom = matrix.length-1, left = 0, right = matrix[0].length-1;
        int size = matrix.length * matrix[0].length;
        while(ans.size() < size){
            for(int i=left; i<=right && ans.size() < size; i++)
                ans.add(matrix[top][i]);
            top++;
            for(int i=top; i<=bottom && ans.size() < size; i++)
                ans.add(matrix[i][right]);
            right--;
            for(int i=right; i>=left && ans.size() < size; i--)
                ans.add(matrix[bottom][i]);
            bottom--;
            for(int i=bottom; i>= top && ans.size() < size; i--)
                ans.add(matrix[i][left]);
            left++;
        }
        return ans;
    }
}



/*
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        int size = m * n;
        while (ans.size() < size) {
            // Traverse right
            for (int j = left; j <= right && ans.size() < size; j++) {
                ans.add(matrix[top][j]);
            }
            top++;
            // Traverse down
            for (int i = top; i <= bottom && ans.size() < size; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            // Traverse left
            for (int j = right; j >= left && ans.size() < size; j--) {
                ans.add(matrix[bottom][j]);
            }
            bottom--;
            // Traverse up
            for (int i = bottom; i >= top && ans.size() < size; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
*/