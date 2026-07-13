class Solution {

    private void dfs(int num, int low, int high, List<Integer> ans) {
        if (num > high)
            return;
        if (num >= low)
            ans.add(num);
        int lastDigit = num % 10;
        if (lastDigit == 9)
            return;
        dfs(num * 10 + lastDigit + 1, low, high, ans);
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 9; i++)
            dfs(i, low, high, ans);
        Collections.sort(ans);
        return ans;
    }
}

/*class Solution {
    private void helper(int low, int high, List<Integer> ans, int l, int num){
        if(num >= low && num<= high)
            ans.add(num);
        if(num > high)
            return;
        for(int i=l; i<=9; i++){
            if(num == 0 || num%10 + 1 == i){
                num *= 10;
                num += i;
                helper(low, high, ans, i+1, num);
                num /= 10;
            }
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        int l = (int)(low / Math.pow(10, (int)Math.log10(low)));
        int r = (int)(high / Math.pow(10, (int)Math.log10(high)));
        helper(low, high, ans, Math.min(l,r), 0);
        Collections.sort(ans);
        return ans;
    }
}*/