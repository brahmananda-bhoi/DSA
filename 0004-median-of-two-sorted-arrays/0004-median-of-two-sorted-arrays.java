class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length+nums2.length;
        double ans=0;
        int i=0,j=0;
        int temp[]=new int [n];
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j])
                temp[k++]=nums1[i++];
            else
                temp[k++]=nums2[j++];
        }
        while(i<nums1.length){
            temp[k++]=nums1[i++];
        }
        while(j<nums2.length){
            temp[k++]=nums2[j++];
        }
        if(n%2==1)
            return (double)temp[n/2];
        else
            ans=(temp[n/2]+temp[n/2-1])/2.0;
        return ans;
    }
}