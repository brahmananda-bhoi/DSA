class Solution {
    public int[] beautifulArray(int n) {
        int[] ans = new int[n];
        int[] temp = new int[]{1};
        while (temp.length < n) {
            int[] next = new int[Math.min(temp.length * 2, n)];
            int k = 0;
            for (int x : temp) if (2 * x - 1 <= n) next[k++] = 2 * x - 1;
            for (int x : temp) if (2 * x     <= n) next[k++] = 2 * x;
            temp = next;
        }
        return temp;
    }
}