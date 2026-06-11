class Solution {
    private static final int MOD = 1_000_000_007;
    private int qpow(int x, int y) {
        long res = 1;
        long base = x;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            y >>= 1;
        }
        return (int) res;
    }
    private int dfs(List<List<Integer>> graph, int node, int parent) {
        int maxDep = 0;
        for (int y : graph.get(node)) {
            if (y == parent) continue;
            maxDep = Math.max(maxDep, dfs(graph, y, node) + 1);
        }
        return maxDep;
    }
    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int maxDep = dfs(graph, 1, 0);
        return qpow(2, maxDep - 1);
        // return (int)(Math.pow(2, maxDep-1) % MOD);
    }
}