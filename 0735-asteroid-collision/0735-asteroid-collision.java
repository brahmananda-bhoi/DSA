class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk1=new Stack<>();
        for(int num : asteroids){
            boolean flag=false;
            if(num>0)
                stk1.push(num);
            else{
                while(!stk1.isEmpty() && stk1.peek()>0 && stk1.peek()+num<=0){
                    if(stk1.pop()+num==0){
                        flag=true;
                        break;
                    }
                }
                if(!stk1.isEmpty() && stk1.peek()<0 && !flag)
                    stk1.push(num);
            }
            if(stk1.isEmpty() && !flag)
                stk1.push(num);
        }
        int res[]=new int [stk1.size()];
        int i=stk1.size()-1;
        while(!stk1.isEmpty())
            res[i--]=stk1.pop();
        return res;
    }
}