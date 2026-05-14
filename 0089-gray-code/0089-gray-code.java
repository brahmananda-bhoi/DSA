class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        ans.add(1);
        int cur = 1;
        for(int i = 2; i <= n; i++){
            cur *= 2;
            for(int j = ans.size()-1; j>=0; j--)
                ans.add(cur+ans.get(j));
        }
        return ans;
    }
}