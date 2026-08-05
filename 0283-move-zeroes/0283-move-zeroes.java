class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length == 1)
            return;
        int j=-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != 0)
                nums[++j] = nums[i];
        }
        for(int i=j+1; i<nums.length; i++)
            nums[i]=0;
    }
}


/*
class Solution {
    public void moveZeroes(int[] arr) {
        if(arr.length==1)
            return;
        int j=1;
        for(int i=0;j<arr.length;i++){
            if(arr[i]!=0){
                j++;
                continue;
            }
            else{
                if(arr[j]!=0){
                    arr[i]=arr[i]+arr[j]-(arr[j]=arr[i]);
                }
                else{
                    j++;
                    i--;
                }
            }
        }
    }
}
*/