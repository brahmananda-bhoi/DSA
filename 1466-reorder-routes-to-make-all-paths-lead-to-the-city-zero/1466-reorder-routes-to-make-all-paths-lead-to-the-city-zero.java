class Solution {
    int count=0;
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<>());
        for(int con[] : connections){
            graph.get(con[0]).add(new int[]{con[1], 1});
            graph.get(con[1]).add(new int[]{con[0], 0});
        }
        boolean[] vis = new boolean[n];
        dfs(0, graph, vis);
        return count;
    }
    private void dfs(int node, List<List<int[]>> graph, boolean[] vis){
        vis[node] = true;
        List<int[]> adj = graph.get(node);
        for(int[] edge : adj){
            if(!vis[edge[0]]){
                count += edge[1];
                dfs(edge[0], graph, vis);
            }
        }
    }
}