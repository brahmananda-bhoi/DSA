class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0, num = 0;
        int temp = n;
        List<Integer> li = new LinkedList<>();
        while(temp > 0){
            int digit = temp%10;
            sum += digit;
            if(digit > 0)
                li.add(0, digit);
            temp /= 10;
        }
        for(int i : li){
            num *= 10;
            num += i;
        }
        return num * sum;
    }
}