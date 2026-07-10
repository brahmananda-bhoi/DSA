class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int res=0, pre=0, n=nums.length;
        for(int i=0; i<n-k; i++){
            pre = Math.max(pre, nums[i]);
            res = Math.max(res, pre+nums[i+k]);
        }
        return res;
    }
}

/**
class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        if(k == 1){
            Arrays.sort(nums);
            return nums[nums.length-1] + nums[nums.length-2];
        }
        if(k > nums.length-1)
            return 0;
        int res=0;
        for(int i=0; i<nums.length-k; i++){
            for(int j=i+k; j<nums.length; j++)
                res = Math.max(res, nums[i]+nums[j]);
        }
        return res;
    }
}
 */