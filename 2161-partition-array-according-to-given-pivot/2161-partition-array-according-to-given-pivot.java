class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int lessI = 0;
        int greaterI = nums.length - 1;
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (nums[i] < pivot)
                ans[lessI++] = nums[i];
            if (nums[j] > pivot)
                ans[greaterI--] = nums[j];
        }
        while (lessI <= greaterI)
            ans[lessI++] = pivot;
        return ans;
    }
}