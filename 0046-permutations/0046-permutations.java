class Solution {
    private void helper(int index, int[] arr, List<Integer> li, List<List<Integer>> ans){
        if(index==arr.length){
            ans.add(new ArrayList(li));
            return;
        }
        for(int i=index; i<arr.length;i++){
            swap(arr,index, i);
            li.add(arr[index]);
            helper(index+1, arr, li, ans);
            li.remove(li.size()-1);
            swap(arr,index, i);
        }
    }
    private void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}





// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         helper(0, nums, ans);
//         return ans;
//     }
//     private void helper(int index, int[] arr, List<List<Integer>> ans) {
//         if (index == arr.length) {
//             List<Integer> li = new ArrayList<>();
//             for (int num : arr) li.add(num);
//             ans.add(li);
//             return;
//         }
//         for (int i = index; i < arr.length; i++) {
//             swap(arr, index, i);
//             helper(index + 1, arr, ans);
//             swap(arr, index, i);
//         }
//     }
//     private void swap(int[] arr, int i, int j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//     }
// }