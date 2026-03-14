class Solution {
    private void help(int n, List<String> ans, StringBuilder sb){
        if(sb.length()==n){
            ans.add(sb.toString());
            return;
        }
        String str="abc";
        for(int i=0;i<3;i++){
            if(sb.length()==0 || sb.charAt(sb.length()-1)!=str.charAt(i)){
                sb.append(str.charAt(i));
                help(n, ans, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
    public String getHappyString(int n, int k) {
        List<String> ans=new ArrayList<>();
        help(n, ans, new StringBuilder());
        return ans.size()<k?"":ans.get(k-1);
    }
}