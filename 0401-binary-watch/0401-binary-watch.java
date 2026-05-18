class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        // Try all possible hours (0-11) and minutes (0-59)
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // Count total bits set in hour and minute
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        return result;
    }
}




/**

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        backtrack(0, 0, 0, turnedOn, result);
        return result;
    }
    
    private void backtrack(int hour, int minute, int count, int target, List<String> result) {
        if (count == target) {
            if (hour < 12 && minute < 60) {
                result.add(String.format("%d:%02d", hour, minute));
            }
            return;
        }
        
        // Try turning on each LED
        for (int i = 0; i < 10; i++) {
            if (i < 4) {
                // Hour LED
                int newHour = hour | (1 << i);
                if (newHour < 12) {
                    backtrack(newHour, minute, count + 1, target, result);
                }
            } else {
                // Minute LED
                int newMinute = minute | (1 << (i - 4));
                if (newMinute < 60) {
                    backtrack(hour, newMinute, count + 1, target, result);
                }
            }
        }
    }
}

 */