class Solution {
    public int trap(int[] height) {
        if(height.length < 3)
            return 0;
        int l=0, r=height.length-1, lmax=0, rmax=0, water=0;
        while(l<r){
            if(height[l] <= height[r]){
                lmax = Math.max(lmax, height[l]);
                water += lmax-height[l++];
            }
            else{
                rmax = Math.max(rmax, height[r]);
                water += rmax-height[r--];
            }
        }
        return water;
    }
}