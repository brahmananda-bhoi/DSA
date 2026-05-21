class Solution {
    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        boolean[] result = new boolean[requests.length];
        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];
            int rootU = find(parent, u);
            int rootV = find(parent, v);
            // Already friends
            if (rootU == rootV) {
                result[i] = true;
                continue;
            }
            // Check if union violates any restriction
            boolean canUnion = true;
            for (int[] restriction : restrictions) {
                int x = restriction[0];
                int y = restriction[1];
                int rootX = find(parent, x);
                int rootY = find(parent, y);
                // Check if merging u and v would connect restricted pair
                if ((rootX == rootU && rootY == rootV) || (rootX == rootV && rootY == rootU)) {
                    canUnion = false;
                    break;
                }
            }
            if (canUnion) {
                parent[rootU] = rootV;  // Union
                result[i] = true;
            }
            else
                result[i] = false;
        }
        return result;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]);
        return parent[x];
    }
}