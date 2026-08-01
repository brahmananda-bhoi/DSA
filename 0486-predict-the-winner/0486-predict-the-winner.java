class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) return true;
        
        int[] dp = nums.clone();
        for (int i = n - 2; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] >= 0;
    }
}



/*class Solution {
    public boolean predictTheWinner(int[] nums) {
        return helper(nums, 0, nums.length - 1) >= 0;
    }
    private int helper(int[] nums, int left, int right) {
        if (left == right)
            return nums[left];
        int pickLeft = nums[left] - helper(nums, left + 1, right);
        int pickRight = nums[right] - helper(nums, left, right - 1);
        // System.out.println(pickLeft + " " + pickRight);
        return Math.max(pickLeft, pickRight);
    }
}*/

/*class Solution {
    private boolean helper(int l, int r, int p1, int p2, int[] nums, boolean flag){
        System.out.println(p1 + " " + p2);
        if(l <= r){
            int s;
            boolean res1, res2;
            s=nums[l];
            if(flag)
                res1 = helper(l+1, r, p1+s, p2, nums, !flag);
            else
                res1 = helper(l+1, r, p1, p2+s, nums, !flag);
            s=nums[r];
            if(flag)
                res2 = helper(l, r-1, p1+s, p2, nums, !flag);
            else
                res2 = helper(l, r-1, p1, p2+s, nums, !flag);
            return res1 || res2;
        }
        return p1 >= p2;
    }
    public boolean predictTheWinner(int[] nums) {
        return helper(0, nums.length-1, 0, 0, nums, true);
    }
}*/