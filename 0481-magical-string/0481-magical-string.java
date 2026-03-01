class Solution {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int count = 1;
        int i = 2;
        while (sb.length() < n) {
            char nextChar = (sb.charAt(sb.length() - 1) == '1') ? '2' : '1';
            int repeat = sb.charAt(i) - '0';
            for (int j = 0; j < repeat && sb.length() < n; j++) {
                sb.append(nextChar);
                if (nextChar == '1')
                    count++;
            }

            i++;
        }
        return count;
    }
}