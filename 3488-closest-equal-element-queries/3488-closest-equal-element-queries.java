class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]))
                map.get(nums[i]).add(i);
            else {
                List<Integer> li = new ArrayList<>();
                li.add(i);
                map.put(nums[i], li);
            }
        }
        // Step 2: Process queries using binary search
        List<Integer> ans = new ArrayList<>();
        for (int query : queries) {
            int value = nums[query];
            List<Integer> indices = map.get(value);
            if (indices.size() == 1) {
                ans.add(-1);
                continue;
            }
            // Binary search to find position of query in sorted indices list
            int pos = Collections.binarySearch(indices, query);
            int size = indices.size();
            // Only check LEFT and RIGHT neighbors in the sorted list
            // Left neighbor (circular)
            int leftIdx = indices.get((pos - 1 + size) % size);
            // Right neighbor (circular)
            int rightIdx = indices.get((pos + 1) % size);
            // Calculate circular distances
            int leftDist = Math.min(Math.abs(query - leftIdx),n - Math.abs(query - leftIdx));
            int rightDist = Math.min(Math.abs(query - rightIdx),n - Math.abs(query - rightIdx));
            ans.add(Math.min(leftDist, rightDist));
        }
        return ans;
    }
}











// class Solution {
//     public List<Integer> solveQueries(int[] nums, int[] queries) {
//         int n = nums.length;
//         HashMap<Integer, List<Integer>> map = new HashMap<>();
//         List<Integer> ans = new ArrayList<>();
//         for (int i = 0; i < nums.length; i++) {
//             if (map.containsKey(nums[i]))
//                 map.get(nums[i]).add(i);
//             else {
//                 List<Integer> li = new ArrayList<>();
//                 li.add(i);
//                 map.put(nums[i], li);
//             }
//         }
//         for (int i = 0; i < queries.length; i++) {
//             int queryIndex = queries[i];
//             int value = nums[queryIndex];
//             if (map.get(value).size() == 1) {
//                 ans.add(-1);
//             } else {
//                 int minDist = Integer.MAX_VALUE;
//                 List<Integer> indices = map.get(value);
//                 for (int idx : indices) {
//                     if (idx == queryIndex) continue;
//                     int directDist = Math.abs(idx - queryIndex);
//                     int circularDist = n - directDist;
//                     int dist = Math.min(directDist, circularDist);
                    
//                     minDist = Math.min(minDist, dist);
//                 }
                
//                 ans.add(minDist);
//             }
//         }
//         return ans;
//     }
// }