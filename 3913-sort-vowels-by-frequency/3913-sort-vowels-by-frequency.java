class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        int[] freq = new int[5];
        int[] firstPos = new int[5];
        // Initialize first position to 'n' (acts as infinity for vowels that don't appear)
        for (int i = 0; i < 5; i++) {
            firstPos[i] = n;
        }
        // 1. Count frequencies and record the first occurrence
        for (int i = 0; i < n; i++) {
            int vIdx = getVowelIndex(s.charAt(i));
            if (vIdx != -1) {
                freq[vIdx]++;
                if (firstPos[vIdx] == n) {
                    firstPos[vIdx] = i;
                }
            }
        }
        // 2. Sort the 5 vowel indices {0, 1, 2, 3, 4}
        int[] order = {0, 1, 2, 3, 4};
        // Simple Bubble/Insertion sort since it's strictly 5 elements (O(1) time)
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                int v1 = order[i];
                int v2 = order[j];
                // Swap condition: higher frequency OR (same frequency but earlier first appearance)
                if (freq[v2] > freq[v1] || (freq[v2] == freq[v1] && firstPos[v2] < firstPos[v1])) {
                    int temp = order[i];
                    order[i] = order[j];
                    order[j] = temp;
                }
            }
        }
        // 3. Place vowels back into the string on the fly
        char[] ans = s.toCharArray();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int orderIdx = 0; // Points to the current vowel we are placing
        int placed = 0;   // Counts how many times we've placed the current vowel
        for (int i = 0; i < n; i++) {
            if (getVowelIndex(ans[i]) != -1) {
                // Skip vowels that appeared 0 times
                while (orderIdx < 5 && freq[order[orderIdx]] == 0) {
                    orderIdx++;
                }
                // Overwrite the vowel at the current position
                ans[i] = vowels[order[orderIdx]];
                placed++;
                // Move to the next vowel type if we've exhausted the current one
                if (placed == freq[order[orderIdx]]) {
                    orderIdx++;
                    placed = 0;
                }
            }
        }
        return new String(ans);
    }
    // Helper to map vowels to indices 0-4
    private int getVowelIndex(char c) {
        if (c == 'a') return 0;
        if (c == 'e') return 1;
        if (c == 'i') return 2;
        if (c == 'o') return 3;
        if (c == 'u') return 4;
        return -1;
    }
}