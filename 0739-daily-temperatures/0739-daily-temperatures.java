class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i])
                stk.pop();
            ans[i]= stk.isEmpty()?0:stk.peek()-i;
            stk.push(i);
        }
        return ans;
    }
}




/*
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk=new Stack<>();
        int size=temperatures.length;
        int ans[]=new int[size];
        for(int i=size-1;i>=0;i--){
            while(!stk.isEmpty() && temperatures[stk.peek()]<=temperatures[i]){
                stk.pop();
            }
            ans[i]=stk.isEmpty()?0:stk.peek()-i;
            stk.push(i);
        }
        return ans;
    }
}
*/