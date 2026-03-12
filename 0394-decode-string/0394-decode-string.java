class Solution {
    public String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<StringBuilder> stk = new Stack<>();
        StringBuilder cur = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c))
                k = k * 10 + (c - '0');
            else if (c == '[') {
                count.push(k);
                stk.push(cur);
                cur=new StringBuilder();
                k = 0;
            }
            else if (c == ']'){
                StringBuilder decoded = stk.pop();
                int repeat=count.pop();
                for(int i=0;i<repeat;i++)
                    decoded.append(cur);
                cur=decoded;
            }
            else
                cur.append(c);
        }
        return cur.toString();
    }
}