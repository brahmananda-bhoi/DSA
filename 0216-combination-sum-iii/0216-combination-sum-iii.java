class Solution {
    private void helper(int num, int sum, int k, int n, List<Integer> li, List<List<Integer>> ans){
        if(li.size()==k){
            if(sum == n)
                ans.add(new ArrayList(li));
            return;
        }
        for(int i=num; i<=9; i++){
            sum+=i;
            li.add(i);
            helper(i+1, sum, k, n, li, ans);
            sum -= i;
            li.remove(li.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(1, 0, k, n, new ArrayList<>(), ans);
        return ans;
    }
}