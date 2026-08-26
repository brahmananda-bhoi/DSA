class Solution {
    int[][] dirs={{1,0}, {-1,0}, {0,1}, {0,-1}};
    private void bfs(char[][] board, int i, int j, boolean[][] vis){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        vis[i][j]=true;
        while(!q.isEmpty()){
            int[] node=q.poll();
            for(int[] dir : dirs){
                int row=node[0]+dir[0];
                int col=node[1]+dir[1];
                if(row>=0 && row<board.length && col>=0 && col<board[0].length && !vis[row][col] && board[row][col]=='O'){
                    q.offer(new int[]{row, col});
                    vis[row][col]=true;
                }
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length, n=board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((i==0 || i==m-1 || j==0 || j==n-1) && board[i][j]=='O' && !vis[i][j])
                    bfs(board, i, j, vis);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!vis[i][j] && board[i][j]=='O')
                    board[i][j]='X';
            }
        }
    }
}