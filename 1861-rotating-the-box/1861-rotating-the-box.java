class Solution {
    private void gravity(char[] row){
        int n = row.length;
        int emptySpace = n-1;
        for(int i = n-1; i >= 0; i--){
            if(row[i] == '#'){
                row[i] = '.';
                row[emptySpace--] = '#';
            }
            else if(row[i] == '*')
                emptySpace = i-1;
        }
    }
    public char[][] rotateTheBox(char[][] boxGrid) {
        for(char[] row : boxGrid)
            gravity(row);
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char[][] ans = new char[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++)
                ans[i][j] = boxGrid[m-1-j][i];
        }
        return ans;
    }
}