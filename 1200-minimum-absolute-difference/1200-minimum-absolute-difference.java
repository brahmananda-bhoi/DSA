class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(arr);
        int diff=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++)
            diff=Math.min(diff,arr[i+1]-arr[i]);
        for(int i=0;i<arr.length-1;i++){
            List<Integer> li=new ArrayList<>();
            if(arr[i+1]-arr[i]==diff){
                li.add(arr[i]);
                li.add(arr[i+1]);
                ans.add(li);
            }
        }
        return ans;
    }
}