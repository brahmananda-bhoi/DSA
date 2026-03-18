class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2,"abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        List<String> ans = new ArrayList<>();
        solve(0, digits, map, new StringBuilder(), ans);
        return ans;
    }
    private void solve(int index, String s, HashMap<Integer, String> map, StringBuilder sb, List<String> ans){
        if(index == s.length()){
            ans.add(sb.toString());
            return;
        }
        String str=map.get(s.charAt(index)-'0');
        for(int i=0; i<str.length(); i++){
            char c=str.charAt(i);
            sb.append(c);
            solve(index+1, s, map, sb, ans);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}