class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stk = new Stack<>();
        int[] ans = new int[n];
        for(int i=2*n-1; i>=0; i--){
            while(!stk.isEmpty() && nums[i%n] >= stk.peek())
                stk.pop();
            if(i<n)
                ans[i] = stk.isEmpty()?-1:stk.peek();
            stk.push(nums[i%n]);
        }
        return ans;
    }
}






/*
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stk=new Stack<>();
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(!stk.isEmpty() && stk.peek()<=nums[i%n])
                stk.pop();
            if(i<n){
                ans[i]=stk.isEmpty()?-1:stk.peek();
            }
            stk.push(nums[i%n]);
        }
        return ans;
    }
}
*/