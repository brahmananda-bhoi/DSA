/**
Also can be solved using KMP STRING MATCHING ALGORITHM
 */
class Solution {
    public String shortestPalindrome(String s) {
        // forwardHash will store hash of the prefix in normal direction
        long forwardHash = 0;
        // reverseHash will store hash of the same prefix but in reverse direction
        long reverseHash = 0;
        // base used for polynomial rolling hash
        long base = 131;
        // power stores base^i to correctly place characters in reverse hash
        long power = 1;
        // pos will store the end index of the longest prefix which is a palindrome
        int pos = -1;
        // Traverse the string and compute rolling hashes
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            // Update forward hash Example: hash = previous_hash * base + current_char
            forwardHash = forwardHash * base + val;
            // Update reverse hash, current_char is multiplied with base^i
            reverseHash = reverseHash + val * power;
            // If both hashes are equal, prefix [0..i] is a palindrome
            if (forwardHash == reverseHash)
                pos = i;
            // Update power for next iteration
            power *= base;
        }
        // The part after the palindrome prefix
        String suffix = s.substring(pos + 1);
        // Reverse the suffix
        StringBuilder sb = new StringBuilder(suffix);
        // Add reversed suffix in front of original string
        // This creates the shortest palindrome
        return sb.reverse().toString() + s;
    }
}