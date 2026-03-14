// class Solution {
//     //This is a classic backtracking + constraint validation problem.
//     void backtrack(int start, int dotsUsed, String currentPath, List<String> result){
        
//     }
//     public List<String> restoreIpAddresses(String s) {
        
//     }
// }


class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }
    private void dfs(String s, int idx, List<String> path, List<String> res) {
        if (path.size() == 4) {
            if (idx == s.length()) {
                res.add(String.join(".", path));
            }
            return;
        }
        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
            String part = s.substring(idx, idx + len);
            if (isValid(part)) {
                path.add(part);
                dfs(s, idx + len, path, res);
                path.remove(path.size() - 1); // backtrack
            }
        }
    }
    private boolean isValid(String s) {
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int val = Integer.parseInt(s);
        return val >= 0 && val <= 255;
    }
}