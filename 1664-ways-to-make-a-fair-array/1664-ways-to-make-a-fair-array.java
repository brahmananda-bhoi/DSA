class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        // Step 1: Calculate total even-indexed and odd-indexed sums
        int totalEven = 0, totalOdd = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0)
                totalEven += nums[i];
            else
                totalOdd += nums[i];
        }
        int count = 0;
        int prefixEven = 0, prefixOdd = 0;
        // Step 2: Check each index
        for (int i = 0; i < n; i++) {
            // Calculate suffix sums (excluding current element)
            int suffixEven, suffixOdd;
            if (i % 2 == 0) {
                suffixEven = totalEven - prefixEven - nums[i];
                suffixOdd = totalOdd - prefixOdd;
            } else {
                suffixEven = totalEven - prefixEven;
                suffixOdd = totalOdd - prefixOdd - nums[i];
            }
            // After removing index i:
            // Elements after i swap parity
            int newEven = prefixEven + suffixOdd;
            int newOdd = prefixOdd + suffixEven;
            if (newEven == newOdd)
                count++;
            // Update prefix sums for next iteration
            if (i % 2 == 0)
                prefixEven += nums[i];
            else
                prefixOdd += nums[i];
        }
        return count;
    }
}