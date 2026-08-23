class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for (int p : piles)
            high = Math.max(high, p);
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;  // current speed
            long hours = 0;
            // total hours needed at speed = mid
            for (int p : piles)
                hours += (p + mid - 1L) / mid; // ceil(p / mid) with integers
            if (hours <= h) {
                // mid is a valid speed, try to minimize it
                ans = mid;
                high = mid - 1;
            }
            else // mid too slow, need higher speed
                low = mid + 1;
        }
        return ans;
    }
}