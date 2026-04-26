class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(nums[0]);
            return ans;
        }
        boolean[] valid = new boolean[n];
        valid[0] = true;
        valid[n - 1] = true;
        int leftMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > leftMax)
                valid[i] = true;
            leftMax = Math.max(leftMax, nums[i]);
        }
        int rightMax = nums[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (nums[i] > rightMax)
                valid[i] = true;
            rightMax = Math.max(rightMax, nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (valid[i])
                ans.add(nums[i]);
        }
        return ans;
    }
}