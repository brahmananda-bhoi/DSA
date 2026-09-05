class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] min = new int[n];
        int cur=Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            cur = Math.min(cur, nums[i]);
            min[i] = cur;
        }
        cur = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            cur = Math.max(cur, nums[i]);
            if(cur - min[i] <= k)
                return i;
        }
        return -1;
    }
}