class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int l = 0, n = s.length();
        boolean flag = true;
        while(l < n){
            int r = l + k - 1 < n ? l + k - 1 : n-1;
            if(flag){
                while(r >= l)
                    sb.append(s.charAt(r--)+"");
                l += k;
            }
            else{
                while(l <= r)
                    sb.append(s.charAt(l++)+"");
            }
            flag = !flag;
        }
        return sb.toString();
    }
}