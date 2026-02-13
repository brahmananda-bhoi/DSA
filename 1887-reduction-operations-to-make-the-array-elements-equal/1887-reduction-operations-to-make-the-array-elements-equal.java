class Solution {
    public int reductionOperations(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        if (nums[0] == nums[n-1])
            return 0;
        int count = 0;
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] != nums[i+1])
                count += (n - 1 - i);
        }
        return count;
    }
}