class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), n, 0, 0);
        return ans;
    }
    private void backtrack(List<String> ans, StringBuilder sb, int n, int open, int close) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backtrack(ans, sb, n, open + 1, close);
            sb.setLength(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backtrack(ans, sb, n, open, close + 1);
            sb.setLength(sb.length() - 1);
        }
    }
}