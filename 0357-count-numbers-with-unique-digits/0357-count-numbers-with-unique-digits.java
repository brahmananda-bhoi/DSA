class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int totalCount = 10; // Base case for n = 1 (digits 0-9)
        int currentUniquePool = 9;
        int availableDigits = 9;
        for (int i = 2; i <= n && availableDigits > 0; i++) {
            currentUniquePool = currentUniquePool * availableDigits;
            totalCount += currentUniquePool;
            availableDigits--;
        }
        return totalCount;
    }
}