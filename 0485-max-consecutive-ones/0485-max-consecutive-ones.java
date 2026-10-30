class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int l=0, r=0, len = 0;
        while(r < nums.length){
            if(nums[r] == 0)
                l = r+1;
            len = Math.max(len, r-l+1);
            r++;
        }
        return len;
    }
}