class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        // The prefix sum can range from -n to n. 
        // We offset it by +n to avoid negative indices.
        int[] count = new int[2 * n + 1];
        int p = n;         // Current prefix sum (starts at 0, offset by n)
        long total = 0;    // Total valid subarrays
        int c = 0;         // Count of previously seen prefix sums strictly less than current 'p'
        // Base case: prefix sum of length 0
        count[p] = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                // Prefix sum increases by 1
                // Add the occurrences of the old prefix sum to 'c'
                c += count[p];
                p++;
            } else {
                // Prefix sum decreases by 1
                // Subtract the occurrences of the new prefix sum from 'c'
                p--;
                c -= count[p];
            }
            // Accumulate valid subarrays ending at this index
            total += c;
            // Record the occurrence of the new prefix sum
            count[p]++;
        }
        return total;
    }
}