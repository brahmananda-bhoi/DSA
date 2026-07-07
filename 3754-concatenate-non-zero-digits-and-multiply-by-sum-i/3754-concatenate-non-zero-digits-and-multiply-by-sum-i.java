class Solution {
    public long sumAndMultiply(int n) {
        long num=0, sum=0, ans=0;
        while(n!=0){
            if(n%10!=0){
                num=num*10+n%10;
                sum+=n%10;
                
            }
            n/=10;
        }
         while(num!=0){
            ans=ans*10+num%10;
            num/=10;
        }
        return ans*sum;
    }
}


/**
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
 */