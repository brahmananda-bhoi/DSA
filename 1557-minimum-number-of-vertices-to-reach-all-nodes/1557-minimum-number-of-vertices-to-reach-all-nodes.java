class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasIncoming = new boolean[n];
        for (List<Integer> edge : edges)
            hasIncoming[edge.get(1)] = true;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!hasIncoming[i])
                ans.add(i);
        }
        return ans;
    }
}


// class Solution {
//     private void dfs(int node, List<List<Integer>> graph, boolean[] vis){
//         vis[node] = true;
//         List<Integer> li = graph.get(node);
//         for(int i : li){
//             if(!vis[i])
//                 dfs(i, graph, vis);
//         }
//     }
//     public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
//         List<List<Integer>> graph = new ArrayList<>();
//         for(int i=0; i<n; i++)
//             graph.add(new ArrayList<>());
//         for(List<Integer> edge : edges)
//             graph.get(edge.get(0)).add(edge.get(1));
//         List<Integer> ans = new ArrayList<>();
//         boolean[] vis = new boolean[n];
//         for(int i=0; i<n; i++){
//             if(!vis[i]){
//                 ans.add(i);
//                 dfs(i, graph, vis);
//             }
//         }
//         return ans;
//     }
// }