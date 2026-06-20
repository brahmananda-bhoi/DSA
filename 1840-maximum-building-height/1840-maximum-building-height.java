class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 0}); // building 1 must be height 0
        boolean hasN = false;
        for (int[] r : restrictions) {
            list.add(new int[]{r[0], r[1]});
            if (r[0] == n)
                hasN = true;
        }
        // Add an implicit restriction for building n:
        // without any other restriction, its max possible height is n - 1
        if (!hasN)
            list.add(new int[]{n, n - 1});
        // Sort by building index
        list.sort(Comparator.comparingInt(a -> a[0]));
        int m = list.size();
        // Left to right pass
        for (int i = 1; i < m; i++) {
            int[] prev = list.get(i - 1);
            int[] curr = list.get(i);
            curr[1] = Math.min(curr[1], prev[1] + (curr[0] - prev[0]));
        }
        // Right to left pass
        for (int i = m - 2; i >= 0; i--) {
            int[] next = list.get(i + 1);
            int[] curr = list.get(i);
            curr[1] = Math.min(curr[1], next[1] + (next[0] - curr[0]));
        }
        long ans = 0;
        // Find the maximum possible peak between every two adjacent restrictions
        for (int i = 1; i < m; i++) {
            int[] a = list.get(i - 1);
            int[] b = list.get(i);
            long dist = (long) b[0] - a[0];
            long peak = (dist + a[1] + b[1]) / 2;
            ans = Math.max(ans, peak);
        }
        return (int) ans;
    }
}