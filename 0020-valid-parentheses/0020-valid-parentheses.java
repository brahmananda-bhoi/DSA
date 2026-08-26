class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {  // If it's an opening bracket, push it onto the stack
                stack.push(c);
            } else {  // If it's a closing bracket
                if (stack.isEmpty() || map.get(stack.pop()) != c) {
                    return false;  // Mismatch or extra closing bracket
                }
            }
        }
        return stack.isEmpty();  // Ensure no unmatched opening brackets remain
    }
}