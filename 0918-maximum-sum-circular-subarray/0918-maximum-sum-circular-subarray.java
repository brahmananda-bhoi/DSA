class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxSum = nums[0], currentMax = 0;
        int minSum = nums[0], currentMin = 0;
        for (int num : nums) {
            currentMax = Math.max(currentMax + num, num);
            maxSum = Math.max(maxSum, currentMax);
            currentMin = Math.min(currentMin + num, num);
            minSum = Math.min(minSum, currentMin);
            totalSum += num;
        }
        if (maxSum < 0) 
            return maxSum;
        return Math.max(maxSum, totalSum - minSum);
    }
    // ═══════════════════════════════════════════════════════════════
        // APPROACH: Kadane's Algorithm + Inverse Kadane's
        // 
        // Two cases for maximum circular subarray:
        // Case 1: Max subarray is in the middle (no wrap) → Use Kadane's
        // Case 2: Max subarray wraps around → Total Sum - Min Subarray
    // ═══════════════════════════════════════════════════════════════
}