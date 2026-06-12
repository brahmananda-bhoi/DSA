class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();
        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }
        boolean[] visited = new boolean[n + 1];
        int minScore = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for(int[] edge : graph[node]){
                int next = edge[0];
                int cost = edge[1];
                minScore = Math.min(minScore, cost);
                if(!visited[next]){
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return minScore;
    }
}