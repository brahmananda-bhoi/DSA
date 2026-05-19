class Solution {
    private void dfs(int node, List<List<Integer>> rooms, boolean[] vis){
        vis[node] = true;
        List<Integer> adj = rooms.get(node);
        for(int j=0; j<adj.size(); j++){
            if(!vis[adj.get(j)])
                dfs(adj.get(j), rooms, vis);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis=new boolean[n];
        dfs(0, rooms, vis);
        for(int i=0; i<n; i++){
            if(!vis[i])
                return false;
        }
        return true;
    }
}




/**

class Solution {
    private void bfs(int node, List<List<Integer>> rooms, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        vis[0]=true;
        while(!q.isEmpty()){
            for(int k : rooms.get(q.poll())){
                if(!vis[k]){
                    vis[k]=true;
                    q.offer(k);
                }
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis=new boolean[n];
        bfs(0, rooms, vis);
        for(int i=0; i<n; i++){
            if(!vis[i])
                return false;
        }
        return true;
    }
}

 */