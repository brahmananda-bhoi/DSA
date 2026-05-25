class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] degree = new int[n + 1];
        Set<Long> edgeSet = new HashSet<>();
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            degree[u]++;
            degree[v]++;
            // Store edge (encode as long to avoid string overhead)
            edgeSet.add(hash(u, v));
        }
        List<Integer> oddNodes = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 == 1)
                oddNodes.add(i);
        }
        int count = oddNodes.size();
        if (count == 0)
            return true;
        if (count == 1 || count == 3 || count > 4)
            return false;
        if (count == 2){
            int u = oddNodes.get(0);
            int v = oddNodes.get(1);
            // Try direct edge
            if (!edgeSet.contains(hash(u, v)))
                return true;
            // Try via intermediate node
            for (int w = 1; w <= n; w++) {
                if (w != u && w != v) {
                    if (!edgeSet.contains(hash(u, w)) && !edgeSet.contains(hash(v, w)))
                        return true;
                }
            }
            return false;
        }
        if (count == 4) {
            int a = oddNodes.get(0);
            int b = oddNodes.get(1);
            int c = oddNodes.get(2);
            int d = oddNodes.get(3);
            // Try all 3 pairings
            if (!edgeSet.contains(hash(a, b)) && !edgeSet.contains(hash(c, d)))
                return true;
            if (!edgeSet.contains(hash(a, c)) && !edgeSet.contains(hash(b, d)))
                return true;
            if (!edgeSet.contains(hash(a, d)) && !edgeSet.contains(hash(b, c)))
                return true;
            return false;
        }
        return false;
    }
    private long hash(int u, int v) {
        return Math.min(u, v) * 100000L + Math.max(u, v);
    }
}