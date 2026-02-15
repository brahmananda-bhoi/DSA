class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length-1;
        int l=0,r=n;
        while(l<=r){
            int mid=l+(r-l)/2;
            if((mid==0 || arr[mid-1]<arr[mid]) && (mid==n || arr[mid+1]<arr[mid]))
                return mid;
            else if((mid==0 || arr[mid+1]>arr[mid]))
                l=mid;
            else
                r=mid;
        }
        return -1;
    }
}