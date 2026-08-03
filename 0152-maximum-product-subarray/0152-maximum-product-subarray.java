class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE, pre=1, suff=1;
        int n = nums.length;
        for(int i=0; i<n; i++){
            pre *= nums[i];
            suff *= nums[n-i-1];
            ans = Math.max(ans, Math.max(pre, suff));
            if(pre == 0)
                pre = 1;
            if(suff == 0)
                suff = 1;
        }
        return ans;
    }
}

/*class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            // store the max because before updating min your max will already be updated
            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}
*/

/*
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            ans = Math.max(ans, nums[i]);
            dp[i][i] = nums[i];
        }
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int temp = dp[i][j-1] * dp[i+1][j];
                ans = Math.max(ans, temp);
                dp[i][j] = temp;
            }
        }
        return ans;
    }
}
*/