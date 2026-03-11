// class Solution {
//     private StringBuilder invert(StringBuilder s){
//         StringBuilder sb=new StringBuilder(s.toString());
//         for(int i=0;i<sb.length();i++){
//             if(sb.charAt(i)=='0')
//                 sb.setCharAt(i,'1');
//             else
//                 sb.setCharAt(i,'0');
//         }
//         return sb;
//     }
//     private String build(int c, int n, StringBuilder sb){
//         if(c==n)
//             return sb.toString();
//         sb.append("1"+invert(sb).reverse().toString());
//         return build(c+1, n, sb);
//     }
//     public char findKthBit(int n, int k) {
//         String s=build(1, n, new StringBuilder("0"));
//         return s.charAt(k-1);
//     }
// }



class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1)
            return '0';
        int length = (1 << n) - 1;
        int mid = length / 2 + 1;
        if (k == mid)
            return '1';
        // If k is in the left half, it is the same as the kth bit in S(n-1)
        if (k < mid)
            return findKthBit(n - 1, k);
        // If k is in the right half, it corresponds to reverse(invert(S(n-1)))
        // So we find the mirrored position in S(n-1)
        char ch = findKthBit(n - 1, length - k + 1);
        // Since the right part is an inverted version, flip the result
        return ch == '0' ? '1' : '0';
    }
}