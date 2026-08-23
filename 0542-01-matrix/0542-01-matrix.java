class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        int m = mat.length, n=mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.offer(new int[]{i,j});
                    dist[i][j]=0;
                    vis[i][j]=true;
                }
            }
        }
        while(!q.isEmpty()){
            int[] node = q.poll();
            for(int[] dir : dirs){
                int newRow=node[0]+dir[0];
                int newCol=node[1]+dir[1];
                if(newRow>=0 && newRow<m && newCol<n && newCol >=0 && !vis[newRow][newCol]){
                    q.offer(new int[]{newRow, newCol});
                    dist[newRow][newCol]=dist[node[0]][node[1]]+1;
                    vis[newRow][newCol]=true;
                }
            }
        }
        return dist;
    }
}