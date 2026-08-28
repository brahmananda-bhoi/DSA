class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stk = new Stack<>();
        int n1=nums1.length, n2=nums2.length;
        int[] ans = new int[n1];
        for(int i=0; i<n1; i++)
            map.put(nums1[i], i);
        for(int i=n2-1; i>=0; i--){
            if(map.containsKey(nums2[i])){
                while(!stk.isEmpty() && nums2[i]>stk.peek())
                    stk.pop();
                ans[map.get(nums2[i])] = stk.isEmpty()?-1:stk.peek();
            }
            stk.push(nums2[i]);
        }
        return ans;
    }
}




/*
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int size=nums1.length;
        int ans[]=new int[size];
        for(int i=0;i<size;i++)
            map.put(nums1[i],i);
        for(int i=nums2.length-1;i>=0;i--){
            if(map.containsKey(nums2[i])){
                while(!stk.isEmpty() && nums2[i]>stk.peek())
                    stk.pop();
                if(stk.isEmpty())
                    ans[map.get(nums2[i])]=-1;
                else
                    ans[map.get(nums2[i])]=stk.peek();
            }
            stk.push(nums2[i]);
        }
        return ans;
    }
}
*/