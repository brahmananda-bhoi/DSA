class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        for (String query : queries) {
            for (String word : dictionary) {
                if (canMatch(query, word)) {
                    ans.add(query);
                    break;
                }
            }
        }
        return ans;
    }
    private boolean canMatch(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2)
                    return false;
            }
        }
        return true;
    }
}