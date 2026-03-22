class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if numRows is 1, return original string
        if (numRows == 1 || numRows >= s.length())
            return s;
        // Create StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) 
            rows[i] = new StringBuilder();
        int currentRow = 0;
        boolean goingDown = false;
        // Traverse each character
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            // Change direction at top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1)
                goingDown = !goingDown;
            // Move to next row
            currentRow += goingDown ? 1 : -1;
        }
        // Combine all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows)
            result.append(row);
        return result.toString();
    }
}