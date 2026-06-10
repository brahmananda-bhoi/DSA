class Solution {
    private void dfs(int node, List<List<Integer>> graph, boolean[] vis){
        vis[node] = true;
        List<Integer> adj = graph.get(node);
        for(int i=0; i<adj.size(); i++){
            if(!vis[adj.get(i)])
                dfs(adj.get(i), graph, vis);
        }
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
            graph.add(new ArrayList<>());
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        dfs(source, graph, vis);
        return vis[destination];
    }
}