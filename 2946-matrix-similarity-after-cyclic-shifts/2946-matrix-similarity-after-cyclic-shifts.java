class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n=mat[0].length, m=mat.length;
        k%=n;
        if(k==0)
            return true;
        int[][] mat1=new int[m][n];
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++)
                mat1[i][j]=mat[i][j];
        }
        while(k>0){
            for(int i=0; i<m; i++){
                if(i%2 == 0){
                    int key=mat1[i][0], j;
                    for(j=1; j<n; j++)
                        mat1[i][j-1]=mat1[i][j];
                    mat1[i][j-1]=key;
                }
                else{
                    int key=mat1[i][n-1], j;
                    for(j=n-1; j>0; j--)
                        mat1[i][j]=mat1[i][j-1];
                    mat1[i][j]=key;
                }
            }
            k--;
        }
        for(int i=0; i<m;i++){
            for(int j=0; j<n;j++){
                if(mat1[i][j] != mat[i][j])
                    return false;
            }
        }
        return true;
    }
}