class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int jumps = 0;
        int currentEnd = 0;   // End of current jump range
        int farthest = 0;     // Farthest index reachable
        for (int i = 0; i < n - 1; i++) {
            // Update farthest reachable from current position
            farthest = Math.max(farthest, i + nums[i]);
            // Reached end of current jump range, must jump
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                // Early exit if we can reach the end
                if (currentEnd >= n - 1)
                    break;
            }
        }
        return jumps;
    }
}