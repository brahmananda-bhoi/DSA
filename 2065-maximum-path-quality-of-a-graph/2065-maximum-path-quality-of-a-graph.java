class Solution {
    int maxQuality = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] visitCount = new int[n];
        dfs(0, 0, values[0], values, graph, visitCount, maxTime);
        return maxQuality;
    }
    private void dfs(int node, int time, int quality, int[] values, List<int[]>[] graph, int[] visitCount, int maxTime) {
        // First visit to this node
        visitCount[node]++;
        // Update max quality if at node 0
        if (node == 0)
            maxQuality = Math.max(maxQuality, quality);
        // Explore neighbors
        for (int[] neighbor : graph[node]) {
            int next = neighbor[0];
            int travelTime = neighbor[1];
            int newTime = time + travelTime;
            if (newTime <= maxTime) {
                int addValue = (visitCount[next] == 0) ? values[next] : 0;
                dfs(next, newTime, quality + addValue, values, graph, visitCount, maxTime);
            }
        }
        // Backtrack
        visitCount[node]--;
    }
}