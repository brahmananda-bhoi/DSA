class Solution {
    private boolean solve(int index, int jump, Map<Integer, Integer> map, int[] stones, Boolean[][] memo) {
        if (index == stones.length - 1)
            return true;
        // Return cached result if already computed
        if (memo[index][jump] != null)
            return memo[index][jump];
        boolean canReachEnd = false;
        // Loop through possible next jumps: jump-1, jump, jump+1
        for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {
            if (nextJump > 0) { // Jump must be strictly forward
                int nextPosition = stones[index] + nextJump;
                if (map.containsKey(nextPosition)) {
                    int nextIndex = map.get(nextPosition);
                    if (solve(nextIndex, nextJump, map, stones, memo)) {
                        canReachEnd = true;
                        break; // Stop searching if a valid path is found
                    }
                }
            }
        }
        return memo[index][jump] = canReachEnd;
    }
    public boolean canCross(int[] stones) {
        // The first jump must always be exactly 1 unit to the second stone
        if (stones[1] != 1) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++)
            map.put(stones[i], i);
        // Maximum jump size at index i is i+1, so stones.length + 1 is safe for the array size
        Boolean[][] memo = new Boolean[stones.length][stones.length + 1];
        // Start from index 1 after having made a jump of size 1
        return solve(1, 1, map, stones, memo);
    }
}



/*
class Solution {
    private boolean solve(int index, int unit, Map<Integer, Integer> map, int[] stones) {
        if (index == stones.length - 1)
            return true;
        // Try jump of size (unit - 1)
        int jump1 = unit - 1;
        if (jump1 > 0) { 
            int target1 = stones[index] + jump1;
            if (map.containsKey(target1)) {
                if (solve(map.get(target1), jump1, map, stones))
                    return true;
            }
        }
        // Try jump of size (unit)
        int jump2 = unit;
        if (jump2 > 0) {
            int target2 = stones[index] + jump2;
            if (map.containsKey(target2)) {
                if (solve(map.get(target2), jump2, map, stones))
                    return true;
            }
        }
        // Try jump of size (unit + 1)
        int jump3 = unit + 1;
        if (jump3 > 0) {
            int target3 = stones[index] + jump3;
            if (map.containsKey(target3)) {
                if (solve(map.get(target3), jump3, map, stones))
                    return true;
            }
        }
        return false;
    }
    public boolean canCross(int[] stones) {
        // The first jump from stone 0 must always be exactly 1 unit to stone 1
        if (stones.length > 1 && stones[1] != 1) 
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++)
            map.put(stones[i], i);
        // Start at index 1, representing that a jump of size 1 was just completed
        return solve(1, 1, map, stones);
    }
}
*/