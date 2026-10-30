class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0,k=nums.length-1;
        /*for(int i=0;i<nums.length && k>=0;i++){
            if(nums[i]==val){
                c++;
                nums[i--]=nums[k--];
                if(i+c==nums.length)
                    break;
                for(int j=i;j<nums.length-1;j++){
                    nums[j]=nums[j+1];
                }
                if(i!=k){
                    nums[i--]=nums[k--];
                }
                else
                    break;
            }
        }*/
        while(i<=k){
            if(nums[i]==val){
                nums[i--]=nums[k--];
            }
            i++;
        }
        return k+1;
    }
}