class Solution {
    private boolean solve(int index, String s, Stack<Character> stk) {
        if (index == s.length())
            return stk.isEmpty();
        char c = s.charAt(index);
        if (c == '(') {
            // DO: Push to stack
            stk.push('(');
            // RECURSE
            if (solve(index + 1, s, stk)) return true;
            // UNDO: The path failed, remove what we just added
            stk.pop();
            return false;
        } 
        else if (c == ')') {
            if (stk.isEmpty()) return false;
            // DO: Pop from stack (we know it's a '(' being popped)
            stk.pop();
            // RECURSE
            if (solve(index + 1, s, stk)) return true;
            // UNDO: The path failed, put the '(' back!
            stk.push('(');
            return false;
        } 
        else { 
            // Character is '*' - We have 3 branches
            // Branch 1: Treat as '('
            stk.push('('); // DO
            if (solve(index + 1, s, stk)) return true; // RECURSE
            stk.pop(); // UNDO
            // Branch 2: Treat as ')'
            if (!stk.isEmpty()) {
                stk.pop(); // DO
                if (solve(index + 1, s, stk)) return true; // RECURSE
                stk.push('('); // UNDO
            }
            // Branch 3: Treat as empty string
            // No stack changes needed, just recurse
            if (solve(index + 1, s, stk)) return true;
            // If all 3 branches fail, return false
            return false;
        }
    }
    public boolean checkValidString(String s) {
        Stack<Character> stk = new Stack<>();
        return solve(0, s, stk);
    }
}