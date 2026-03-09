// We use the Z Algorithm to compute the longest common prefix (LCP)
// between the whole string and every suffix of the string.
class Solution {
    public long sumScores(String s) {
        int n = s.length();
        // z[i] = length of the longest substring starting at i
        // that matches the prefix of the string s
        int[] z = new int[n];
        // left and right define the current "Z-box"
        // a segment [left, right] where we already know
        // the substring matches the prefix
        int left = 0, right = 0;
        // Start from index 1 because z[0] is always 0
        // (the entire string compared with itself is handled separately)
        for (int i = 1; i < n; i++) {
            // If i is inside the current Z-box
            if (i <= right)
                // Use previously computed values to avoid recomputation
                // z[i-left] represents the mirror value inside the Z-box
                z[i] = Math.min(right - i + 1, z[i - left]);
            // Try to extend the match beyond the Z-box
            // Compare characters one by one
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
                z[i]++;
            // If the match goes beyond the current right boundary,
            // update the Z-box
            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i] - 1;
            }
        }
        // The full string matches itself completely
        // so its score is n
        long ans = n;
        // Add all Z values
        // each z[i] represents the LCP between
        // the string and the suffix starting at i
        for (int val : z)
            ans += val;
        return ans;
    }
}