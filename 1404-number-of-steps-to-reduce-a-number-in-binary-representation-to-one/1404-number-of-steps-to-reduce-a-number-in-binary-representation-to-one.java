class Solution {
    public int numSteps(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 1) {
            if (sb.charAt(sb.length() - 1) == '1') {
                int carry = 1;
                int i = sb.length() - 1;
                while (i >= 0 && carry != 0) {
                    if (sb.charAt(i) == '1')
                        sb.setCharAt(i, '0');
                    else{
                        sb.setCharAt(i, '1');
                        carry = 0;
                    }
                    i--;
                }
                if (carry == 1)
                    sb.insert(0, '1');
                count++;
            }
            else{
                sb.setLength(sb.length() - 1);
                count++;
            }
        }

        return count;
    }
}





/*

class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int carry = 0;
        int res = 0;
        for (int i = n - 1; i > 0; i--){
            if (s.charAt(i) - '0' + carry == 1){
                res += 2;
                carry = 1;
            }
            else{
                res++;
            }
        }
        return res + carry;
    }
}

*/
