class Solution {
    public int maxDigitRange(int[] nums) {
        int sum=0, max=0, n=nums.length;
        int[] temp = new int[n];
        for(int i=0; i<n; i++){
            int num = nums[i], dmin = Integer.MAX_VALUE, dmax = Integer.MIN_VALUE;
            while(num > 0){
                int digit = num%10;
                dmin = Math.min(dmin, digit);
                dmax = Math.max(dmax, digit);
                num/=10;
            }
            temp[i] = dmax - dmin;
            max = Math.max(max, temp[i]);
        }
        for(int i=0; i<n; i++){
            if(temp[i] == max)
                sum += nums[i];
        }
        return sum;
    }
}