class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        return mergeSortAndCount(nums, temp, 0, nums.length - 1);
    }
    
    private int mergeSortAndCount(int[] nums, int[] temp, int left, int right) {
        if (left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        int count = 0;
        count += mergeSortAndCount(nums, temp, left, mid);
        count += mergeSortAndCount(nums, temp, mid + 1, right);
        count += mergeAndCount(nums, temp, left, mid, right);
        return count;
    }
    private int mergeAndCount(int[] nums, int[] temp, int left, int mid, int right) {
        // Copy elements to temp array
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }
        int count = 0;
        // Step 1: Count reverse pairs using two pointers
        int p = left;                    // pointer in left half
        for (int j = mid + 1; j <= right; j++) {
            // Move p until nums[p] > 2 * nums[j] is no longer true
            while (p <= mid && (long) nums[p] <= 2L * nums[j]) {
                p++;
            }
            // All elements from p to mid satisfy nums[i] > 2 * nums[j]
            count += (mid - p + 1);
        }
        // Step 2: Normal merge of two sorted halves
        int i = left;       // left half pointer
        int j = mid + 1;    // right half pointer
        int k = left;       // merged position
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements from left half (if any)
        while (i <= mid) {
            nums[k] = temp[i];
            i++;
            k++;
        }
        // Remaining elements in right half are already in correct position
        return count;
    }
}