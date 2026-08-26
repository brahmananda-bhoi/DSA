class MinStack {
    class Node{
        int val, min;
        public Node(int v){
            val=v;
        }
    }
    Stack<Node> stk;
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int value) {
        Node node=new Node(value);
        if(stk.isEmpty())
            node.min=value;
        else{
            Node top = stk.peek();
            node.min=top.min<=value?top.min:value;
        }
        stk.push(node);
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek().val;
    }
    
    public int getMin() {
        return stk.peek().min;
    }
}


/*
class MinStack {
    Stack<Long> stk;
    long min;
    public MinStack() {
        stk = new Stack<>();
        min = 0;
    }
    public void push(int val) {
        if (stk.isEmpty()) {
            min = val;
            stk.push((long) val);
        } else {
            if (val >= min) {
                stk.push((long) val);
            } else {
                // Encode the value to store previous min
                stk.push(2L * val - min);
                min = val;
            }
        }
    }
    public void pop() {
        if (stk.isEmpty()) return;
        long top = stk.pop();
        if (top < min) {
            // Decode the previous min
            min = 2 * min - top;
        }
    }
    public int top() {
        if (stk.isEmpty()) return -1;
        long top = stk.peek();
        if (top >= min) {
            return (int) top;
        } else {
            return (int) min;
        }
    }
    public int getMin() {
        return (int) min;
    }
}
*/

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */