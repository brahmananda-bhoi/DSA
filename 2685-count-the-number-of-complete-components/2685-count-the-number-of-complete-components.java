class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
            graph.add(new ArrayList());
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        int count=0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                List<Integer> comp = new ArrayList<>();
                dfs(i, graph, vis, comp);
                int ver = comp.size();
                int degree = 0;
                for(int node : comp)
                    degree += graph.get(node).size(); 
                int edgesInComp = degree / 2;
                int expEdges = ver * (ver-1) / 2;
                if(edgesInComp == expEdges)
                    count++;
            }
        }
        return count;
    }
    private void dfs(int node, List<List<Integer>> graph, boolean[] vis, List<Integer> comp){
        vis[node] = true;
        comp.add(node);
        for(int next : graph.get(node)){
            if(!vis[next])
                dfs(next, graph, vis, comp);
        }
    }
}


/**
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited = new boolean[n];
        int completeComponents = 0;
        for (int i = 0; i < n; i++){
            if (!visited[i]){
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                int vertices = component.size();
                int degreeSum = 0;
                for (int node : component)
                    degreeSum += graph[node].size();
                int edgesInComponent = degreeSum / 2;
                int expectedEdges = vertices * (vertices - 1) / 2;
                if (edgesInComponent == expectedEdges)
                    completeComponents++;
            }
        }
        return completeComponents;
    }
    private void dfs(int node, List<Integer>[] graph, boolean[] visited,List<Integer> component){
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph[node]){
            if (!visited[neighbor])
                dfs(neighbor, graph, visited, component);
        }
    }
}
 */