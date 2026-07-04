class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++)
            graph[i] = new ArrayList<>();
        for(int[] road : roads){
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }
        boolean[] vis = new boolean[n+1];
        int score = Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        vis[1] = true;
        q.offer(1);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int[] edge : graph[node]){
                int next = edge[0];
                int cost = edge[1];
                score = Math.min(score, cost);
                if(!vis[next]){
                    vis[next] = true;
                    q.offer(next);
                }
            }
        }
        return score;
    }
}