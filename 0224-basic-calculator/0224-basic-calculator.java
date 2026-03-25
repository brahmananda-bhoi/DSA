class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int num = 0;
        int sign = 1;  // 1 for +, -1 for -
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                // Add previous number to result
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                // Add previous number to result
                result += sign * num;
                num = 0;
                sign = -1;
                
            } else if (c == '(') {
                // Save current state and reset
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // Complete current parentheses
                result += sign * num;
                num = 0;
                // Apply saved sign and add saved result
                result *= stack.pop();  // Pop sign
                result += stack.pop();  // Pop previous result
            }
            // Ignore spaces
        }
        // Don't forget the last number
        result += sign * num;
        return result;
    }
}