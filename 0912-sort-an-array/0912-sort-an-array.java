class Solution {
    private void merge(int[] arr, int l, int mid, int r){
        int n1=mid-l+1;
        int n2=r-mid;
        int a1[]=new int[n1];
        int a2[]=new int[n2];
        int j=l;
        for(int i=0;i<n1;i++)
            a1[i]=arr[j++];
        j=mid+1;
        for(int i=0;i<n2;i++)
            a2[i]=arr[j++];
        int i=0, k=l;
        j=0;
        while(i<n1 && j<n2){
            if(a1[i]<=a2[j])
                arr[k]=a1[i++];
            else
                arr[k]=a2[j++];
            k++;
        }
        while(i<n1){
            arr[k]=a1[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=a2[j];
            k++;
            j++;
        }
    }
    private void mergeSort(int[] arr, int l, int r){
        if(l<r){
            int mid=l+(r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr, l, mid, r);
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
}