class Solution {
    private int[] parent;
    private int[] rank;
    public int largestComponentSize(int[] nums) {
        // Find max value to size the Union-Find arrays
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }
        // Initialize Union-Find
        parent = new int[maxVal + 1];
        rank = new int[maxVal + 1];
        for (int i = 0; i <= maxVal; i++) {
            parent[i] = i;
        }
        // Union each number with its factors
        for (int num : nums) {
            for (int factor = 2; factor * factor <= num; factor++) {
                if (num % factor == 0) {
                    union(num, factor);
                    union(num, num / factor);
                }
            }
        }
        // Count component sizes (only for numbers in nums array)
        Map<Integer, Integer> componentSize = new HashMap<>();
        int maxSize = 0;
        for (int num : nums) {
            int root = find(num);
            int size = componentSize.getOrDefault(root, 0) + 1;
            componentSize.put(root, size);
            maxSize = Math.max(maxSize, size);
        }
        return maxSize;
    }
    // Find with path compression
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    // Union by rank
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return;
        if (rank[px] < rank[py]) {
            parent[px] = py;
        } else if (rank[px] > rank[py]) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
    }
}