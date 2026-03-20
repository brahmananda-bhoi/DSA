class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length();
        int n2 = num2.length();
        // result[i] represents the digit at 10^i place
        int[] result = new int[n1 + n2];
        // Multiply each pair of digits
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // position from right
                int pos = (n1 - 1 - i) + (n2 - 1 - j);
                // add to current position
                int sum = mul + result[pos];
                result[pos] = sum % 10;
                // carry to next higher position
                int carry = sum / 10;
                int k = pos + 1;
                while (carry > 0) {
                    sum = result[k] + carry;
                    result[k] = sum % 10;
                    carry = sum / 10;
                    k++;
                }
            }
        }
        // Build the result string (skip leading zeros)
        StringBuilder sb = new StringBuilder();
        boolean started = false;
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i] > 0 || started) {
                started = true;
                sb.append(result[i]);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}