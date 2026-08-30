class Solution {
    public int minimumDeletions(int[] nums) {
        int max=0, min=0;
        for(int i=1; i<nums.length; i++){
            max = nums[i]>nums[max]?i:max;
            min = nums[i]<nums[min]?i:min;
        }
        int c1 = Math.max(max, min)+1;
        int c2 = nums.length-Math.min(max, min);
        int c3 = (Math.min(min, max)+1) + (nums.length - Math.max(max, min));
        // System.out.println(c1 + " | " + c2 + " | " + c3);
        return Math.min(c1, Math.min(c2, c3));
    }
}