class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        // Step 1: Group indices by values
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        // Step 2: For each group, calculate distances using prefix sum
        for (List<Integer> indices : map.values()) {
            int size = indices.size();
            // Build prefix sum of indices
            long[] prefix = new long[size];
            prefix[0] = indices.get(0);
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + indices.get(i);
            }
            for (int i = 0; i < size; i++) {
                long idx = indices.get(i);
                // Left part: indices[0..i-1] are all < idx
                // Sum of (idx - indices[j]) for j < i
                long leftSum = idx * i - (i > 0 ? prefix[i - 1] : 0);
                // Right part: indices[i+1..size-1] are all > idx
                // Sum of (indices[j] - idx) for j > i
                long rightSum = (prefix[size - 1] - prefix[i]) - idx * (size - 1 - i);
                arr[indices.get(i)] = leftSum + rightSum;
            }
        }
        return arr;
    }
}