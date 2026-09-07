class Solution {
    public void evaluateOpr(char prevOpr, int num, Deque<Integer> nums) {
        if (prevOpr == '/')
            nums.addLast(nums.removeLast() / num);
        else if (prevOpr == '*')
            nums.addLast(nums.removeLast() * num);
        else if (prevOpr == '+')
            nums.addLast(num);
        else
            nums.addLast(num * -1);
    }
    public int calculate(String s) {
        int num = 0;
        char prevOpr = '+';
        Deque<Integer> nums = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == ' ')
                continue;
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else {
                evaluateOpr(prevOpr, num, nums);
                prevOpr = ch;
                num = 0;
            }
        }
        evaluateOpr(prevOpr, num, nums);
        num = 0;
        for (int n : nums)
            num += n;
        return num;
    }
}