class Solution {
    private void help(int index, List<List<Integer>> ans, List<Integer> li, int n, int k){
        if(li.size()==k){
            ans.add(new ArrayList<>(li));
            return;
        }
        for(int i=index;i<=n;i++){
            li.add(i);
            help(i+1, ans, li, n, k);
            li.remove(li.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        help(1, ans, new ArrayList<>(), n, k);
        return ans;
    }
}