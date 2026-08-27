class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if(vis[i] != -1)
                continue;
            q.offer(i);
            vis[i] = 0;
            while (!q.isEmpty()) {
                int node = q.poll();
                int[] ngbrs = graph[node];
                for (int ngbr : ngbrs) {
                    if (vis[node] == vis[ngbr])
                        return false;
                    if (vis[ngbr] == -1) {
                        vis[ngbr] = vis[node] == 1 ? 0 : 1;
                        q.offer(ngbr);
                    }
                }
            }
        }
        return true;
    }
}