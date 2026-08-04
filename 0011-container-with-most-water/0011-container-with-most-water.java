class Solution {
    public int maxArea(int[] height) {
        int i=0,j=height.length-1,min;
        int max=0;
        while(i<j){
            min=height[i]>height[j]?height[j]:height[i];
            if(max<(min*(j-i))){
                max=min*(j-i);
            }
            if(height[i] < height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return max;
    }
}