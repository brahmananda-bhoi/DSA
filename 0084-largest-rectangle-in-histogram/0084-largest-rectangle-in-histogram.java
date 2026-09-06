class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stk = new Stack<>();
        int[] pse = new int[n];
        int[] nse = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i])
                stk.pop();
            nse[i] = stk.isEmpty()?n:stk.peek();
            stk.push(i);
        }
        stk.clear();
        for(int i=0; i<n; i++){
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i])
                stk.pop();
            pse[i] = stk.isEmpty()?-1:stk.peek();
            stk.push(i);
        }
        int area = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
            area = Math.max(area, (nse[i]-pse[i]-1) * heights[i]);
        return area;
    }
}



/*
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length, area=0;
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[stk.peek()]>heights[i]){
                int el=stk.pop();
                int nse=i;
                int pse=stk.isEmpty()?-1:stk.peek();
                area=Math.max(area,heights[el]*(nse-pse-1));
            }
            stk.push(i);
        }
        while(!stk.isEmpty()){
            int el=stk.pop();
            int pse=stk.isEmpty()?-1:stk.peek();
            area=Math.max(area,heights[el]*(n-pse-1));
        }
        return area;
    }
}
*/