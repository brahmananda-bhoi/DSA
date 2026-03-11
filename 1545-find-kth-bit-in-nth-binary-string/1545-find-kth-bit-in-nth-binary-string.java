class Solution {
    private StringBuilder invert(StringBuilder s){
        StringBuilder sb=new StringBuilder(s.toString());
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='0')
                sb.setCharAt(i,'1');
            else
                sb.setCharAt(i,'0');
        }
        return sb;
    }
    private String build(int c, int n, StringBuilder sb){
        if(c==n)
            return sb.toString();
        sb.append("1"+invert(sb).reverse().toString());
        return build(c+1, n, sb);
    }
    public char findKthBit(int n, int k) {
        String s=build(1, n, new StringBuilder("0"));
        return s.charAt(k-1);
    }
}