class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap to store the frequency of prefix sums
        HashMap<Integer, Integer> prefixSumCounts = new HashMap<>();
        // Initialize with prefix sum 0 occurring once (for subarrays starting at index 0)
        prefixSumCounts.put(0, 1);
        int count = 0;
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            // Check if there is a prefix sum that when subtracted from current gives k
            if (prefixSumCounts.containsKey(prefixSum - k)) {
                count += prefixSumCounts.get(prefixSum - k);
            }
            // Update the count of the current prefix sum in the map
            prefixSumCounts.put(prefixSum, prefixSumCounts.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}