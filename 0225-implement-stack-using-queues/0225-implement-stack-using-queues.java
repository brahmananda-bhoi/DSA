class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList<>();
    }
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        while (size-- > 1) {
            q.offer(q.poll());
        }
    }
    public int pop() {
        return q.poll();
    }
    public int top() {
        return q.peek();
    }
    public boolean empty() {
        return q.isEmpty();
    }
}






// class MyStack {
//     Queue<Integer> q1, q2;
//     public MyStack() {
//         q1 = new LinkedList<>();
//         q2 = new LinkedList<>();
//     }
//     public void push(int x) {
//         q1.offer(x);
//     }
//     public int pop() {
//         if (q2.isEmpty()) {
//             while (q1.size() > 1)
//                 q2.offer(q1.poll());
//             return q1.poll();
//         } else {
//             while (q2.size() > 1)
//                 q1.offer(q2.poll());
//             return q2.poll();
//         }
//     }
//     public int top() {
//         int topVal;
//         if (q2.isEmpty()) {
//             // Move all but last from q1 to q2
//             while (q1.size() > 1)
//                 q2.offer(q1.poll());
//             topVal = q1.poll();  // Get last element
//             q2.offer(topVal);    // Put it back in q2! ✓
//         } else {
//             // Move all but last from q2 to q1
//             while (q2.size() > 1)
//                 q1.offer(q2.poll());
//             topVal = q2.poll();  // Get last element
//             q1.offer(topVal);    // Put it back in q1! ✓
//         }
//         return topVal;
//     }
//     public boolean empty() {
//         return q1.isEmpty() && q2.isEmpty();
//     }
// }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */