class Solution {
    public int[] sortByBits(int[] arr) {
        // Convert int[] to Integer[] for custom sorting
        Integer[] nums = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++)
            nums[i] = arr[i];
        // Custom comparator
        Arrays.sort(nums, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if (countA == countB)
                return a - b;   // sort by value if bits equal
            return countA - countB; // sort by bit count
        });
        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }
}