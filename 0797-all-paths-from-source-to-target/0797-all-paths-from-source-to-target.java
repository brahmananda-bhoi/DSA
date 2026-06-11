class Solution {
    private void dfs(int node, int[][] graph, List<List<Integer>> paths, List<Integer> path){
        path.add(node);
        if(node == graph.length-1){
            paths.add(new ArrayList<>(path));
            return;
        }
        int[] adj = graph[node];
        for(int i : adj){
            dfs(i, graph, paths, path);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths = new ArrayList<>();
        dfs(0, graph, paths, new ArrayList<>());
        return paths;
    }
}