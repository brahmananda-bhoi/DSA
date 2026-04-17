class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            int curr = nums[j];
            // If some previous index i had reverse(nums[i]) == curr
            if (map.containsKey(curr))
                ans = Math.min(ans, j - map.get(curr));
            // Store reverse(nums[j]) -> j
            int rev = reverse(curr);
            map.put(rev, j);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}